package com.anmoon.mentionbox;

import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataElasticsearchTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    private ItemEntity item1;
    private ItemEntity item2;

    @BeforeEach
    public void setUp() {
        // Set up test data
        item1 = new ItemEntity();
        item1.setTitle("Title 1");
        item1.setDesc("Description for Title 1");
//
//        item2 = new ItemEntity();
//        item2.setTitle("Title 2");
//        item2.setDescription("Description for Title 2");
//
//        // Save items to Elasticsearch
//        itemRepository.save(item1);
//        itemRepository.save(item2);
    }

    @Test
    public void testFindByTitleAndDesc_withKeyword() {
        // Define the search keyword
        String keyword = "Bode";
        Pageable pageable = PageRequest.of(0, 10);

        // Call the repository method
        List<ItemEntity> result = itemRepository.findByTitleAndDesc(keyword, pageable);

        // Assert that the result contains only item1
        System.out.println(result);
        assertEquals(1, result.size());
        assertEquals("In a Dry Season", result.get(0).getTitle());
    }

    @Test
    public void testFindByTitleAndDesc_withDescription() {
        // Define a different keyword
        String keyword = "Description for Title 2";
        Pageable pageable = PageRequest.of(0, 10);

        // Call the repository method
        List<ItemEntity> result = itemRepository.findByTitleAndDesc(keyword, pageable);

        // Assert that the result contains only item2
        assertEquals(1, result.size());
        assertEquals("Title 2", result.get(0).getTitle());
    }
}

