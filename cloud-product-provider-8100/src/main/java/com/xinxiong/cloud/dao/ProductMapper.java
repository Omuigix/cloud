package com.xinxiong.cloud.dao;

import com.xinxiong.cloud.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    /**
     * 查询
     * @param id
     * @return
     */
    public Product selectById(@Param("id") Long id);


    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteById(@Param("id") Long id);

    /**
     * 修改
     * @param id
     * @param name
     * @return
     */
    public int updateById(@Param("id") Long id, @Param("name") String name);

    /**
     * 新增
     * @param product
     * @return
     */
    public int insertOne(Product product);
}