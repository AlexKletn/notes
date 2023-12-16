package com.example.notes2.common.itemsList;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ItemsListResponse<ItemType> {
     public static <ItemType> ItemsListResponse<ItemType> create(ItemsList<ItemType> itemsList) {
        ItemsListResponse<ItemType> listResponse = new ItemsListResponse<ItemType>();

        listResponse.setCount(itemsList.getCount());
        listResponse.setItems(itemsList.getItems());
        listResponse.setTotal(itemsList.getTotal());

        return listResponse;
    }

    protected Integer count;

    protected Integer total;

    protected List<ItemType> items;
}
