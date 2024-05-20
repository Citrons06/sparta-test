package com.sparta.spartatest.controller;

import com.sparta.spartatest.domain.ItemRequestDto;
import com.sparta.spartatest.domain.ItemResponseDto;
import com.sparta.spartatest.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ItemResponseDto createBoard(@RequestBody ItemRequestDto requestDto) {
        return itemService.createItem(requestDto);
    }

    @GetMapping
    public List<ItemResponseDto> findList() {
        return itemService.findList();
    }

    @PutMapping("/{id}")
    public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.updateItem(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body("{\"msg\" : \"삭제완료\"}");
    }
}
