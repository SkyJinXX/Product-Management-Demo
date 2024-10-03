package com.example.inventory_service.service;

import com.example.inventory_service.mapper.InventoryMapper;
import com.example.inventory_service.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    public int getQuantityByProductId(Long productId) {
        return inventoryMapper.findQuantityByProductId(productId);
    }

    public void addInventory(Inventory inventory) {
        inventoryMapper.insertInventory(inventory);
    }

    public void updateInventory(Long productId, Inventory inventory) {
        inventoryMapper.updateInventory(productId, inventory.getQuantity());
    }

    public void deleteInventory(Long productId) {
        inventoryMapper.deleteInventory(productId);
    }
}
