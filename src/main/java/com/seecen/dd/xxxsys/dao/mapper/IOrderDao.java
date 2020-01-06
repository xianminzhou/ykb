package com.seecen.dd.xxxsys.dao.mapper;

import com.seecen.dd.xxxsys.dao.domain.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface IOrderDao {


    @Insert("insert into orders (id, order_num, order_status, \n" +
            "      order_amount, paid_amount, product_id, \n" +
            "      buy_counts, create_time, paid_time\n" +
            "      )\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{orderNum,jdbcType=VARCHAR}, #{orderStatus,jdbcType=VARCHAR}, \n" +
            "      #{orderAmount,jdbcType=VARCHAR}, #{paidAmount,jdbcType=VARCHAR}, #{productId,jdbcType=VARCHAR}, \n" +
            "      #{buyCounts,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, #{paidTime,jdbcType=TIMESTAMP}\n" +
            "      )")
    void insert(Orders order);


    Orders getOrderById(@Param("orderId") String orderId);


    int updateById(Orders orders);
}
