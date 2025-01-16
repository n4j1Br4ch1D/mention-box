package com.anmoon.mentionbox.service;

import com.anmoon.mentionbox.dto.request.ItemRequest;
import com.anmoon.mentionbox.dto.response.ItemResponse;
import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Iterable<ItemResponse> getItems() {
        Iterable<ItemEntity> items = itemRepository.findAll();
        //int sizeOfItems = items.;
        List<ItemResponse> result = new ArrayList<>();
        for (ItemEntity item : items) {
            result.add(ItemResponse.builder().title(item.getTitle()).description(item.getDesc()).nbr(0).build());
        }
        return result;
    }

    public ItemEntity insertItems(ItemEntity item) {
        return itemRepository.save(item);
    }

    public List<ItemResponse> searchItemsByTitleAndDesc(ItemRequest itemRequest, int page, int size) {
        String splitKeywors[] = itemRequest.getKeywords().split(" ");
        List<ItemResponse> result = new ArrayList<>();
        for(int i=0;i<splitKeywors.length;i++){
            List<ItemEntity> responce = itemRepository.findByTitleAndDesc(splitKeywors[i], PageRequest.of(page, size));
            for (ItemEntity item : responce) {
                if(!result.contains(ItemResponse.builder().title(item.getTitle()).description(item.getDesc()).nbr(0).build())) {
                    int nbrOfWords =0  ;
                    String splits[] = item.getDesc().split(" ");
                    for(int j=0;j<splits.length;j++){
                        if(splits[j].equals(splitKeywors[i])){
                            nbrOfWords++;
                        }
                    }
                    //result.stream().
                    result.add(ItemResponse.builder().title(item.getTitle()).description(item.getDesc()).nbr(nbrOfWords).build());
                }else{
                    int nbrOfWords =0  ;
                    for(ItemResponse itemResponse : result){
                        if(itemResponse.equals(ItemResponse.builder().title(item.getTitle()).description(item.getDesc()).nbr(0).build())){
                            nbrOfWords=itemResponse.nbr;
                        }
                    }
                    String splits[] = item.getDesc().split(" ");
                    for(int j=0;j<splits.length;j++){
                        if(splits[j].equals(splitKeywors[i])){
                            nbrOfWords++;
                        }
                    }
                    result.add(ItemResponse.builder().title(item.getTitle()).description(item.getDesc()).nbr(nbrOfWords).build());
                }
            }
        }
        return result;
    }

    public List<ItemResponse> getAllItems(String keyword, int page, int size) {
        Iterable<ItemEntity> iter = itemRepository.findAll();
        List<ItemResponse> result = new ArrayList<>();
        for (ItemEntity item : iter) {
            result.add(ItemResponse.builder().title(item.getTitle()).description(item.getDesc()).nbr(0).build());
        }
        return new ArrayList<>(result);
    }

}
