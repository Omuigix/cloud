package com.xinxiong.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xinxiong.cloud.service.ProductService;
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

    @Resource
    ProductService productService;

//    public static String url = "http://localhost:8100/";
    public static String url = "http://cloud-product-provider/";

    /**
     * 查询
     * @return
     */
    @GetMapping("product/consumer/get/info")
    public Result selectById() {
        return productService.getServiceInfo();
//        return new Result(200, "查询成功",
//                restTemplate.getForObject(url + "product/provider/get/info", Result.class));
    }

    /**
     * 查询
     * 注：熔断函数参数要一致
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "getErroInfo")
    @GetMapping("product/consumer/get/{id}")
    public Result selectById(@PathVariable("id") Long id) {
        return new Result(200, "查询成功",
                restTemplate.getForObject(url + "product/provider/get/" + id, Result.class));
    }

    @GetMapping("product/consumer/delete/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        return productService.deleteById(id);
    }

//    public Result getErroInfo(Long id){
//        return new Result(500, "服务器内部出现错误", null);
//    }
}