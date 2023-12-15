package com.example.notes2.api.Common.responses;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public abstract class ListResponse<ItemType> {
    protected Integer count;

    protected List<ItemType> items;
}
