package com.xinxiong.cloud.controller;

import com.xinxiong.cloud.dto.Result;
import com.xinxiong.cloud.entity.Product;
import com.xinxiong.cloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/")
public class ProductProviderController {

    @Value("${spring.application.name}")
    private String instantName;

    @Value("${server.port}")
    private String port;

    @Resource
    private ProductService productService;

    @GetMapping("product/provider/get/info")
    public Result geServieInfo(){
        return new Result(200, "查询成功", "当前服务名："+ instantName + " 当前端口："+ port);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("product/provider/get/{id}")
    public Result selectById(@PathVariable("id") Long id){
        return new Result(200, "查询成功", productService.selectById(id));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("product/provider/delete/{id}")
    public Result deleteById(@PathVariable("id") Long id){
        return new Result(200, "删除成功", productService.deleteById(id));
    }

    /**
     * 修改
     * @param product
     * @return
     */
    @PostMapping("product/provider/update")
    public Result updateById(@RequestBody Product product){
        return new Result(200, "修改成功", productService.updateById(product.getId(), product.getName()));

    }

    /**
     * 新增
     * @return
     */
    @PutMapping( "product/provider/add")
    public Result insertById(@RequestBody Product product){
        return new Result(200, "修改成功", productService.insertOne(product));
    }

    @GetMapping("product/provider/error")
    public Result error() {
        System.out.println(1 / 0);
        return new Result(200, "成功", "success??????");
    }
}