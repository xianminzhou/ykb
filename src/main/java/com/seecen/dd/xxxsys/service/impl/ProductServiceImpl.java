package com.seecen.dd.xxxsys.service.impl;

import com.seecen.dd.xxxsys.dao.domain.Product;
import com.seecen.dd.xxxsys.dao.mapper.IProductdao;
import com.seecen.dd.xxxsys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private IProductdao iProductdao;


    @Override
    public List<Product> getProducts() {
        return iProductdao.getAllProduct();
    }

    @Override
    public Product getProductById(String productId) {
        return iProductdao.getProductById(productId);
    }

    @Override
    public Integer deleteById(String productId) {
        return iProductdao.deleteById(productId);
    }
}
