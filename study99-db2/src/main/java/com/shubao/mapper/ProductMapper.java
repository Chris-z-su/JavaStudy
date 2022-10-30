package com.shubao.mapper;

import com.shubao.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    // @Select("select * from administrator.Producttb")
    List<Product> findAll();

    int insertProduct(Product product);

}
