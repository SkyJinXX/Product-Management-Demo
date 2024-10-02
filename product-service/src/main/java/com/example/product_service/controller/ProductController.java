package com.example.product_service.controller;

import com.example.product_service.client.InventoryClient;
import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final InventoryClient inventoryClient;
    private final ProductService productService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public ProductController(InventoryClient inventoryClient, ProductService productService) {
        this.inventoryClient = inventoryClient;
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts() {
        // 先从 Redis 缓存中查找库存信息
        String cachedInventory = redisTemplate.opsForValue().get("inventory");
        if (cachedInventory != null) {
            return "Product list with cached inventory: " + cachedInventory;
        }

        // 如果缓存中没有，就调用 inventory-service 获取库存信息
        String inventory = inventoryClient.getInventory();

        // 将库存信息存入 Redis 缓存
        redisTemplate.opsForValue().set("inventory", inventory);

        return "Product list with inventory: " + inventory;
    }

    @GetMapping("/products/db")
    public List<Product> getAllProductsFromDb() {
        return productService.getAllProducts(); // 调用 ProductService 来获取所有产品信息
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product); // 添加产品到数据库
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product); // 更新产品信息
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id); // 删除产品
    }
}
