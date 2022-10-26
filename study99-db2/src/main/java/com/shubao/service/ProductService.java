package com.shubao.service;

import com.shubao.mapper.ProductMapper;
import com.shubao.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Product> queryAllProducts(){
        List<Product> productList = productMapper.findAll();
        return productList;
    }

    public int updateProduct() {
        // productMapper.updateProduct();

        return 0;
    }



}
