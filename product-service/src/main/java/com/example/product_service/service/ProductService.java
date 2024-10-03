package com.example.product_service.service;

import com.example.product_service.client.InventoryClient;
import com.example.product_service.mapper.ProductMapper;
import com.example.product_service.model.Product;
import com.example.inventory_service.model.Inventory;
import com.example.product_service.model.ProductWithQuantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private InventoryClient inventoryClient;

    @Autowired
    private ProductMapper productMapper;

    // 添加产品时同时创建库存
    public void addProductWithInventory(Product product, int initialQuantity) {
        // 保存产品
        productMapper.insertProduct(product);
        // 创建对应的库存
        inventoryClient.createInventory(new Inventory(product.getId(), initialQuantity));
    }

    @Cacheable(value = "inventoryCache", key = "#productId")
    public ProductWithQuantity getProductWithInventory(Long productId) {
        Product product = productMapper.findById(productId);
        int quantity = inventoryClient.getQuantityByProductId(productId);
        return new ProductWithQuantity(product, quantity);
    }

    public List<ProductWithQuantity> getAllProductsWithInventory() {
        List<Product> products = productMapper.findAll();
        return products.stream().map(product -> {
            int quantity = inventoryClient.getQuantityByProductId(product.getId());
            return new ProductWithQuantity(product, quantity);
        }).collect(Collectors.toList());
    }

    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    public void deleteProduct(Long productId) {
        productMapper.deleteProduct(productId);
        // 删除缓存
        evictCache(productId);
    }

    @CacheEvict(value = "inventoryCache", key = "#productId")
    public void evictCache(Long productId) {
        // 手动清除缓存
    }


}
