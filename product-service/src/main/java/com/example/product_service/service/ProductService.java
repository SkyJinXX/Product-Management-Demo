package com.example.product_service.service;

import com.example.product_service.mapper.ProductMapper;
import com.example.product_service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productMapper.findAll();
    }

    public void addProduct(Product product) {
        productMapper.insertProduct(product);
    }

    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    public void deleteProduct(Long id) {
        productMapper.deleteProduct(id);
    }
}
