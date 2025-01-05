package com.anmoon.mentionbox.repository;

import com.anmoon.mentionbox.entity.ItemEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<ItemEntity, Integer> {
}
