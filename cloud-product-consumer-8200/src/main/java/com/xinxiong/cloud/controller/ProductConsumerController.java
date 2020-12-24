package com.xinxiong.cloud.controller;

import com.xinxiong.cloud.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ProductConsumerController {

    @Resource
    RestTemplate restTemplate;

    public static String url = "http://localhost:8100/";

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("product/consumer/get/{id}")
    public Result selectById(@PathVariable("id") Long id){

        return new Result(200, "查询成功",
                restTemplate.getForObject(url+"product/provider/get/"+id, Result.class));
    }

}