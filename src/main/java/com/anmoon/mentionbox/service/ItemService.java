package com.anmoon.mentionbox.service;

import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    public Iterable<ItemEntity> getItems() {
        return itemRepository.findAll();
    }

    public ItemEntity insertItems(ItemEntity item) {
        return itemRepository.save(item);
    }
}
