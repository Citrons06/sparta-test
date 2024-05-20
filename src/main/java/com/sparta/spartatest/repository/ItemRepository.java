package com.sparta.spartatest.repository;

import com.sparta.spartatest.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
