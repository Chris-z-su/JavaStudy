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
        List<Product> productList = productService.queryAllProducts();
        return productList;
    }

    @GetMapping("/insert")
    public int insertProduct(){
        String result = productService.insertProduct();
        System.out.println("result = " + result);

        return 0;
    }

}
