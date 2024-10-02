package com.example.product_service.mapper;

import com.example.product_service.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {

    @Select("SELECT * FROM product")
    List<Product> findAll();

    @Insert("INSERT INTO product(name, description, price) VALUES(#{name}, #{description}, #{price})")
    void insertProduct(Product product);

    @Update("UPDATE product SET name=#{name}, description=#{description}, price=#{price} WHERE id=#{id}")
    void updateProduct(Product product);

    @Delete("DELETE FROM product WHERE id=#{id}")
    void deleteProduct(Long id);
}
