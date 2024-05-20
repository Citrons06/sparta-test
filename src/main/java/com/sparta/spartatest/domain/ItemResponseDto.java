package com.sparta.spartatest.domain;

import lombok.Data;

@Data
public class ItemResponseDto {

    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
