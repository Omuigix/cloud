package com.xinxiong.cloud.service.impl;

import com.xinxiong.cloud.dao.ProductMapper;
import com.xinxiong.cloud.entity.Product;
import com.xinxiong.cloud.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductMapper productMapper;

    public Product selectById(Long id) {
        return productMapper.selectById(id);
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
}