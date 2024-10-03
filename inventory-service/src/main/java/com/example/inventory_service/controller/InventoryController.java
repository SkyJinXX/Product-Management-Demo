package com.example.inventory_service.controller;

import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory/{productId}")
    public int getQuantityByProductId(@PathVariable Long productId) {
        return inventoryService.getQuantityByProductId(productId);
    }

    @PostMapping("/inventory")
    public void addInventory(@RequestBody Inventory inventory) {
        inventoryService.addInventory(inventory);
    }

    @PutMapping("/inventory/{productId}")
    public void updateInventory(@PathVariable Long productId, @RequestBody Inventory inventory) {
        inventoryService.updateInventory(productId, inventory);
    }

    @DeleteMapping("/inventory/{productId}")
    public void deleteInventory(@PathVariable Long productId) {
        inventoryService.deleteInventory(productId);
    }
}
