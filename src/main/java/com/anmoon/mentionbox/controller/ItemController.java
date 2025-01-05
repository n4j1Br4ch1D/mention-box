package com.anmoon.mentionbox.controller;

import com.anmoon.mentionbox.config.ApiEndpointsConstants;
import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndpointsConstants.ITEMS_PATH)
public class ItemController {
//    @Autowired
//    private ItemService itemService;
    @GetMapping("/findAll")
    Iterable<ItemEntity> findAll(){
        return null; //itemService.getProducts();

    }

    @PostMapping("/insert")
    public ItemEntity insertProduct(@RequestBody ItemEntity itemEntity){
        return null; //itemService.insertProduct(product);
    }
}
