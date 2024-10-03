package com.example.inventory_service.mapper;

import com.example.inventory_service.model.Inventory;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InventoryMapper {

    @Select("SELECT quantity FROM inventory WHERE product_id = #{productId}")
    int findQuantityByProductId(Long productId);

    @Insert("INSERT INTO inventory(product_id, quantity) VALUES(#{productId}, #{quantity})")
    void insertInventory(Inventory inventory);

    @Update("UPDATE inventory SET quantity = #{quantity} WHERE product_id = #{productId}")
    void updateInventory(@Param("productId") Long productId, @Param("quantity") int quantity);

    @Delete("DELETE FROM inventory WHERE product_id = #{productId}")
    void deleteInventory(Long productId);
}
