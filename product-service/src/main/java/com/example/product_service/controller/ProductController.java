package com.example.product_service.controller;

import com.example.product_service.client.InventoryClient;
import com.example.product_service.model.Product;
import com.example.product_service.model.ProductWithQuantity;
import com.example.product_service.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final InventoryClient inventoryClient;
    private final ProductService productService;

    public ProductController(InventoryClient inventoryClient, ProductService productService) {
        this.inventoryClient = inventoryClient;
        this.productService = productService;
    }

    @GetMapping("/products/db")
    public List<ProductWithQuantity> getAllProductsFromDb() {
        return productService.getAllProductsWithInventory(); // 调用 ProductService 来获取所有产品信息
    }

    @GetMapping("/products/{id}")
    public ProductWithQuantity getProductWithInventory(@PathVariable Long id) {
        return productService.getProductWithInventory(id);
    }

    @PostMapping("/products")
    public void addProductWithInventory(@RequestBody Product product, @RequestParam int initialQuantity) {
        productService.addProductWithInventory(product, initialQuantity);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id); // 删除产品
    }
}
