package com.xinxiong.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {

    private Long id; //自增id
    private String name;// 产品名称
    private int stock;// 库存

}