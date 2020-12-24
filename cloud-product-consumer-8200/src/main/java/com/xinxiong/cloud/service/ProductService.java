package com.xinxiong.cloud.service;

import com.xinxiong.cloud.dto.Result;
import com.xinxiong.cloud.service.impl.ProductFallbackServieImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="cloud-product-provider", fallback = ProductFallbackServieImpl.class)
public interface ProductService {

    /**
     * 查询
     * @return
     */
    @GetMapping("product/provider/get/info")
    Result getServiceInfo();

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("product/provider/get/{id}")
    Result selectById(@PathVariable("id") Long id);

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("product/provider/delete/{id}")
    Result deleteById(@PathVariable("id") Long id);

    @GetMapping("product/provider/error")
    Result error();
}
