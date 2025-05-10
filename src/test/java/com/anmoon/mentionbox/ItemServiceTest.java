package com.anmoon.mentionbox;

import com.anmoon.mentionbox.dto.response.ItemResponse;
import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.repository.ItemRepository;
import com.anmoon.mentionbox.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    private ItemEntity item1;
    private ItemEntity item2;

    @BeforeEach
    void setUp() {
        // Initialize mock data
        item1 = new ItemEntity();
        item1.setTitle("In a Dry Season");
        item1.setDesc("Dorian Bode Speech Gay Men's Press");

        item2 = new ItemEntity();
        item2.setTitle("Frequent Hearses");
        item2.setDesc("May the Force be with you.");
    }

    @Test
    void testSearchItemsByTitleAndDesc_withKeyword() {
        String keyword = "Bode";
        Pageable pageable = PageRequest.of(0, 10);
        List<ItemResponse> results = itemService.searchItemsAll(keyword, 0,10);

        //Assert: Verify the results
        assertNotNull(results);
        //System.out.println(results);
        assertFalse(results.isEmpty());
       //assertTrue(results.stream().anyMatch(item -> item.getTitle().contains("In a Dry Season")));
    }

    @Test
    void testSearchItemsByTitleAndDesc_noMatchingItems() {
        // Given
        String keyword = "nonexistent";
        int page = 0;
        int size = 10;

        List<ItemEntity> mockItems = new ArrayList<>();

        // Mock the repository method to return an empty list
        when(itemRepository.findByTitleAndDesc(Mockito.anyString(), Mockito.any(PageRequest.class)))
                .thenReturn(mockItems);

        // When
        List<ItemResponse> result = itemService.searchItemsByTitleAndDesc(keyword, page, size);

        // Then
        assertEquals(0, result.size());  // No items should be found
    }

    @Test
    void testSearchItemsByTitleAndDesc_multipleKeywords() {
        // Given
        String keyword = "test description";
        int page = 0;
        int size = 10;

        List<ItemEntity> mockItems = new ArrayList<>();
        mockItems.add(item1);
        mockItems.add(item2);

        // Mock the repository method to return the same items
        when(itemRepository.findByTitleAndDesc(Mockito.anyString(), Mockito.any(PageRequest.class)))
                .thenReturn(mockItems);

        // When
        List<ItemResponse> result = itemService.searchItemsByTitleAndDesc(keyword, page, size);

        // Then
        assertEquals(2, result.size());  // Two items should still be found
        assertEquals("Test Item 1", result.get(0).getTitle());
        assertEquals("Test Item 2", result.get(1).getTitle());
        assertEquals(1, result.get(0).getNbr());  // One match for 'test description'
        assertEquals(1, result.get(1).getNbr());  // One match for 'test description'
    }
}
