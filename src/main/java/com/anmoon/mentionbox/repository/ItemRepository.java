package com.anmoon.mentionbox.repository;

import com.anmoon.mentionbox.entity.ItemEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<ItemEntity, Long> {

    @Query("{\"bool\": {\"should\": [{\"match\": {\"title\": \"?0\"}}, {\"match\": {\"desc\": \"?0\"}}]}}")
    List<ItemEntity> findByTitleAndDesc(String keyword, Pageable pageable);
}
