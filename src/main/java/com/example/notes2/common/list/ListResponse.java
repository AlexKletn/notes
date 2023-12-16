package com.example.notes2.common.list;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ListResponse<ItemType> {
    public static <ItemType> ListResponse<ItemType> create(List<ItemType> list) {
        return ListResponse.create(list, list.size());
    }

    static <ItemType>  ListResponse<ItemType> create(List<ItemType> list, Integer total) {
        ListResponse<ItemType> listResponse = new ListResponse<ItemType>();

        listResponse.setCount(list.size());
        listResponse.setItems(list);
        listResponse.setTotal(total);

        return listResponse;
    }

    protected Integer count;

    protected Integer total;

    protected List<ItemType> items;
}
