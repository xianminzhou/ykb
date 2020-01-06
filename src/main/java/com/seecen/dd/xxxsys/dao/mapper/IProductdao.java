package com.seecen.dd.xxxsys.dao.mapper;

import com.seecen.dd.xxxsys.dao.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductdao {


    @Select("select * from product ")
    List<Product> getAllProduct();

    @Select("select * from product where id=#{id}")
    Product getProductById(String id);

    @Delete("delete from product where id=#{id}")
    Integer deleteById(String id);

    @Insert("insert into product values(#{id},#{name},#{price})")
    Integer Insert(Product product);
}
