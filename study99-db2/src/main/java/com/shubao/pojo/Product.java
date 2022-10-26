package com.shubao.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @program: JavaStudy
 * @description:
 * @author: chris
 * @create: 2022-10-25 23:33
 * @since JDK1.8
 **/
@Data
public class Product {
    private Date snap_dt;
    private Integer ptid;
    private String ptname;
    private Integer pdid;
    private String pdname;
    private Integer num;
}
