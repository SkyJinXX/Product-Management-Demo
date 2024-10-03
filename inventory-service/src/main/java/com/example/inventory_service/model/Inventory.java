package com.example.inventory_service.model;


public class Inventory {

    private Long id;        // Unique identifier for each inventory record
    private Long productId;  // Foreign key linking to the product in the product-service
    private int quantity;    // The available quantity of the product
    private String lastUpdated;  // Timestamp for when the inventory was last updated

    // Default constructor
    public Inventory() {}

    // Constructor with all fields
    public Inventory(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
