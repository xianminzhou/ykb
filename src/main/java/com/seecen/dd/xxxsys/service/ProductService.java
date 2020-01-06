package com.seecen.dd.xxxsys.service;

import com.seecen.dd.xxxsys.dao.domain.Product;

import java.util.List;

/**
 * @Classname AlipayController
 * @Description TODO
 * @Date 2019/3/21 20:40
 * @Created by 爆裂无球
 */
public interface ProductService {

	/**
	 * 获取所有产品列表
	 * @return
	 */
	public List<Product> getProducts();
	
	/**
	 * 根据产品ID查询产品详情
	 * @param productId
	 * @return
	 */
	public Product getProductById(String productId);

	public Integer deleteById(String productId);
}
