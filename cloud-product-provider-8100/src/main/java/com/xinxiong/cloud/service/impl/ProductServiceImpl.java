package com.xinxiong.cloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xinxiong.cloud.dao.ProductMapper;
import com.xinxiong.cloud.entity.Product;
import com.xinxiong.cloud.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductMapper productMapper;

    @HystrixCommand(fallbackMethod = "selectByIdFallbackHandler", commandProperties = {
            // 是否启用服务熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求阈值
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 错误比率
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    public Product selectById(Long id) {
        if(id < 0) {
            System.out.println(id / 0);
        }
        return productMapper.selectById(id);
    }

    public Product selectByIdFallbackHandler(Long id) {
        System.out.println("启动了熔断函数selectByIdFallbackHandler");
        return null;
    }

    public int deleteById(Long id) {
        return productMapper.deleteById(id);
    }

    public int updateById(Long id, String name) {
        return productMapper.updateById(id, name);
    }

    public int insertOne(Product product) {
        return productMapper.insertOne(product);
    }

    @HystrixCommand(fallbackMethod = "selectByIdFallbackHandler", commandProperties = {
            // 是否启用服务熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求阈值
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 错误比率
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    public Product error() {
        System.out.println(1 / 0);
        return new Product();
    }

    public Product selectByIdFallbackHandler() {
        System.out.println("启动了熔断函数selectByIdFallbackHandler");
        return null;
    }
}