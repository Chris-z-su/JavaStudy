package com.shubao.controller;

import com.shubao.service.ProductService;
import com.shubao.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @version 1.0
 * @program: JavaStudy
 * @description: 产品控制器
 * @author: chris
 * @create: 2022-10-25 23:30
 * @since JDK1.8
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getProductList(){
        // List<Product> productList = jdbcTemplate.query("SELECT * FROM administrator.Producttb",
        //         new BeanPropertyRowMapper<>(Product.class));

        List<Product> productList = productService.queryAllProducts();
        return productList;
    }

    @GetMapping("/insert")
    public int insertProduct(){
        String sql = "";
        int n = 0;
        LocalDate startDate = LocalDate.parse("2022-04-11");
        for (int i = 0; i < 100000000; i++) {
            sql = "INSERT INTO ADMINISTRATOR.PRODUCTTB (SNAP_DT, PTID, PTNAME, PDID, PDNAME, NUM) " +
                    "VALUES('" + startDate.toString() + "', 1, '电子产品', " + i+1 + ", '笔记本电脑', 100); ";
            n = jdbcTemplate.update(sql);
            startDate = startDate.plusDays(1);
        }
        return n;
    }

}
