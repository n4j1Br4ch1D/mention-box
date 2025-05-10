package com.anmoon.mentionbox.seeder;

import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.provider.CustumerFaker;
import com.anmoon.mentionbox.repository.ItemRepository;
import com.anmoon.mentionbox.seedable.Seedable;
import com.anmoon.mentionbox.service.EmbeddingService;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ItemSeeder implements Seedable {

    private final ItemRepository itemRepository;

    private final EmbeddingService embeddingService;

    @Autowired
    public ItemSeeder(ItemRepository itemRepository,
                      EmbeddingService embeddingService) {
        this.itemRepository = itemRepository;
        this.embeddingService = embeddingService;
    }

    @Override
    public void seed() {
        CustumerFaker custumerFaker = new CustumerFaker();
        for (int i = 0; i < 10; i++) {
            ItemEntity itemEntity = new ItemEntity();
            String type = custumerFaker.itemProvider().weightedItemName();
            itemEntity.setTitle(custumerFaker.itemProvider().title(type));
            itemEntity.setDesc(custumerFaker.itemProvider().description(type));
            itemEntity.setEmbedding(embeddingService.getEmbedding(itemEntity.getDesc() + itemEntity.getTitle()));
            itemRepository.save(itemEntity);
            log.info(type + " " +itemEntity.toString());
        }
    }

    @Override
    public void rollback() {

    }
}
