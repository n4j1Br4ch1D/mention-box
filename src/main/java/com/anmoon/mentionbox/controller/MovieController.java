package com.anmoon.mentionbox.controller;

import com.anmoon.mentionbox.dto.response.ItemResponse;
import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.mapper.ItemEntityMapper;
import com.anmoon.mentionbox.service.ItemService;
import com.anmoon.mentionbox.service.OmdbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {

    @Autowired
    private  OmdbService omdbService;
    @Autowired
    private ItemService itemService;


    @GetMapping("/details")
    public ItemResponse getMovieDetails(@RequestParam String title) {
//        log.info("ddd =>{}", 2);
        ItemResponse movieDetails = omdbService.getMovieDetails(title);
       log.info("lololo=>{}", movieDetails.getActors());
        ItemEntity item = ItemEntityMapper.INSTANCE.mapToItemEntity(movieDetails);
        //item.setId(1); // Assuming you set the ID separately
        itemService.insertItems(item);
        ItemResponse respo = ItemEntityMapper.INSTANCE.mapToItemResponse(item);
        return respo;
    }

    @GetMapping("/findAll")
    Iterable<ItemEntity> findAll(){
        return itemService.getItems();

    }
}

