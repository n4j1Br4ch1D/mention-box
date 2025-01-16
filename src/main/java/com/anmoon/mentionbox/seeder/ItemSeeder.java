package com.anmoon.mentionbox.seeder;

import com.anmoon.mentionbox.entity.ItemEntity;
import com.anmoon.mentionbox.provider.CustumerFaker;
import com.anmoon.mentionbox.repository.ItemRepository;
import com.anmoon.mentionbox.seedable.Seedable;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ItemSeeder implements Seedable {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemSeeder(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void seed() {
        CustumerFaker custumerFaker = new CustumerFaker();
        for (int i = 0; i < 10; i++) {
            ItemEntity itemEntity = new ItemEntity();
            String type = custumerFaker.itemProvider().weightedItemName();
            itemEntity.setTitle(custumerFaker.itemProvider().title(type));
            itemEntity.setDesc(custumerFaker.itemProvider().description(type));
            itemRepository.save(itemEntity);
            log.info(type + " " +itemEntity.toString());
        }
    }

    @Override
    public void rollback() {

    }
}
