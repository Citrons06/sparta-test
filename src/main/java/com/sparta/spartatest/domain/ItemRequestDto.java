package com.sparta.spartatest.domain;

import lombok.Data;

@Data
public class ItemRequestDto {

    private String username;
    private String title;
    private String content;
    private int price;

    public ItemRequestDto(String username, String title, String content, int price) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }
}
