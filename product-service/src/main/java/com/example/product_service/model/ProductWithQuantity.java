package com.example.product_service.model;

import com.example.inventory_service.model.Inventory;

public class ProductWithQuantity extends Product {

    private int quantity;

    public ProductWithQuantity(Product product, int quantity) {
        // 调用父类构造方法，初始化 Product
        super(product.getId(), product.getName(), product.getDescription(), product.getPrice()); // 根据 Product 类的构造函数进行初始化
        this.quantity = quantity;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


