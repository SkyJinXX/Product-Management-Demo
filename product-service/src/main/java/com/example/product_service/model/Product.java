package com.example.product_service.model;

public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;

    public Product(Long id, String name,   String description, Double price) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}