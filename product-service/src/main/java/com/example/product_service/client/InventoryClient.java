package com.example.product_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("inventory-service")  // 调用服务名为 inventory-service 的服务
public interface InventoryClient {

    @GetMapping("/inventory")
    String getInventory();
}
