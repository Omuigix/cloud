package com.xinxiong.cloud.service.impl;

import com.xinxiong.cloud.dto.Result;
import com.xinxiong.cloud.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductFallbackServieImpl implements ProductService {

    public Result getServiceInfo() {
        return new Result(500,"服务器内部出现错误，导致getServiceInfo接口异常",null);
    }

    public Result selectById(Long id) {
        return new Result(500,"服务器内部出现错误，导致selectById接口异常",null);
    }

    public Result deleteById(Long id) {
        return new Result(500,"服务器内部出现错误，导致deleteById接口异常",null);
    }
}