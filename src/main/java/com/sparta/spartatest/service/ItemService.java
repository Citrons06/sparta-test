package com.sparta.spartatest.service;

import com.sparta.spartatest.domain.Item;
import com.sparta.spartatest.domain.ItemRequestDto;
import com.sparta.spartatest.domain.ItemResponseDto;
import com.sparta.spartatest.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    //게시글 작성
    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = new Item(requestDto);
        itemRepository.save(item);
        return new ItemResponseDto(item);
    }

    //게시글 전체 리스트 조회
    @Transactional(readOnly = true)
    public List<ItemResponseDto> findList() {
        return itemRepository.findAll().stream()
                .map(ItemResponseDto::new)
                .toList();
    }

    //게시글 수정
    public ItemResponseDto updateItem(Long id, ItemRequestDto requestDto) {
        Item item = itemRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        item.update(requestDto);

        return new ItemResponseDto(item);
    }

    //게시글 삭제
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
