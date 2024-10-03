package com.example.product_service.client;

import com.example.inventory_service.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("inventory-service")
public interface InventoryClient {

    @PostMapping("/inventory")
    void createInventory(@RequestBody Inventory inventory);

    @GetMapping("/inventory/{productId}")
    int getQuantityByProductId(@PathVariable("productId") Long productId);
}
