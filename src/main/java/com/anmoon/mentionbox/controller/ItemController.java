package com.anmoon.mentionbox.controller;

import com.anmoon.mentionbox.config.ApiEndpointsConstants;
import com.anmoon.mentionbox.dto.request.ItemRequest;
import com.anmoon.mentionbox.dto.response.ItemResponse;
import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndpointsConstants.ITEMS_PATH)
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/findAll")
    Iterable<ItemResponse> findAll(){
      return itemService.getItems();
    }

    @GetMapping("/search")
    Iterable<ItemResponse> findItemsByTitleAndDesc(@RequestParam ItemRequest title, @RequestParam int page, @RequestParam int size){
        return itemService.searchItemsByTitleAndDesc(title,page,size);
    }


    @PostMapping("/insert")
    public ItemEntity insertProduct(@RequestBody ItemEntity itemEntity){
        return itemService.insertItems(itemEntity);
    }
}
