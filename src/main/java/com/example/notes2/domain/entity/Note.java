package com.example.notes2.domain.entity;

import lombok.*;

@Data
public class Note  {
    private final Long id;
    private User owner;
    private String title;
    private String description;
}
