package com.shubao.service;

import com.shubao.mapper.ProductMapper;
import com.shubao.pojo.Product;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @version 1.0
 * @program: JavaStudy
 * @description:
 * @author: chris
 * @create: 2022-10-26 00:09
 * @since JDK1.8
 **/
@Service
public class ProductService {

    /**
     * 产品分类
     */
    private List<String> ptnames = new ArrayList<String>(Arrays.asList("食品", "家电", "数码", "服饰"));

    /**
     * 产品明细
     */
    private List<String> pdnames = new ArrayList<String>(Arrays.asList("休闲零食", "坚果炒货", "饮料",
            "牛奶", "饼干", "牛排", "龙井", "红茶", "乌龙茶", "食用油", "白酒", "啤酒", "红酒", "水果蔬菜", "方便食品",
            "平板电视", "空调", "冰箱", "洗衣机", "家庭影院", "净化器", "吸尘器", "加湿器", "电饭煲", "豆浆机", "电烤箱",
            "路由器", "网卡", "交换机", "网络存储", "笔记本", "游戏本", "平板电脑", "CPU", "主板", "显卡", "硬盘", "手机",
            "羽绒服", "棉服", "连衣裙", "卫衣", "夹克", "保暖内衣", "秋衣秋裤", "睡衣", "打底裤", "运动鞋", "凉鞋", "皮鞋"));

    @Autowired
    private ProductMapper productMapper;

    /**
     * 每次处理1000条
     */
    private static final int BATCH_SIZE = 10000000; // 150000000

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public List<Product> queryAllProducts(){
        List<Product> productList = productMapper.findAll();
        return productList;
    }

    /**
     * 批量处理修改或者插入
     */
    public String insertProduct() {
        // productMapper.updateProduct();

        List<Product> productList = new ArrayList<>();

        LocalDate startDate = LocalDate.parse("2012-01-01");

        for (int i = 1; i <= BATCH_SIZE; i++){
            Product product = new Product();
            product.setSnap_dt(startDate.toString());
            int ptid = (int) (Math.random() * ptnames.size());
            String ptname = ptnames.get(ptid);
            product.setPtid(ptid);
            product.setPtname(ptname);
            int pdid = (int) (Math.random() * pdnames.size());
            String pdname = pdnames.get(pdid);
            product.setPdid(pdid);
            product.setPdname(pdname);
            product.setNum((int) (Math.random() * 1000 + 1));
            productList.add(product);
            if (i % 50 == 0) {
                startDate = startDate.plusDays(1);
            }
        }
        long time = System.currentTimeMillis();
        batchUpdateOrInsert(productList, ProductMapper.class,
                (product, productMapper) -> productMapper.insertProduct(product));
        long time1 = System.currentTimeMillis();
        String result = "批量插入"+ (double)productList.size()/10000+"W条数据耗时："+(time1-time);

        return result;
    }

    /**
     * 批量处理修改或者插入
     * https://blog.csdn.net/Zhao__Mr/article/details/126029560
     *
     * @param data     需要被处理的数据
     * @param mapperClass  Mybatis的Mapper类
     * @param function 自定义处理逻辑
     * @return int 影响的总行数
     */
    public  <T,U,R> int batchUpdateOrInsert(List<T> data, Class<U> mapperClass, BiFunction<T,U,R> function) {
        int i = 1;
        SqlSession batchSqlSession = sqlSessionFactory.openSession();
        batchSqlSession.getConfiguration().setDefaultExecutorType(ExecutorType.BATCH);
        try {
            U mapper = batchSqlSession.getMapper(mapperClass);
            int size = data.size();
            for (T element : data) {
                function.apply(element,mapper);
                if ((i % BATCH_SIZE == 0) || i == size) {
                    System.out.println(batchSqlSession.flushStatements());
                }
                i++;
            }
            // 非事务环境下强制commit，事务情况下该commit相当于无效
            batchSqlSession.commit(!TransactionSynchronizationManager.isSynchronizationActive());
        } catch (Exception e) {
            batchSqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            batchSqlSession.close();
        }
        return i - 1;
    }



}
