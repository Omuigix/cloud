package com.xinxiong.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.xinxiong.cloud.dao")
@EnableDiscoveryClient
public class ProductProvider8100 {

    public static void main(String[] args){
        SpringApplication.run(ProductProvider8100.class, args);
    }
}