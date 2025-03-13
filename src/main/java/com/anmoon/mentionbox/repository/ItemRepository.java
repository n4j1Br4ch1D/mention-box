package com.anmoon.mentionbox.repository;

import com.anmoon.mentionbox.entity.ItemEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<ItemEntity, Long> {

    @Query("{\"bool\": {\"should\": [{\"match\": {\"title\": \"?0\"}}, {\"match\": {\"desc\": \"?0\"}}]}}")
    List<ItemEntity> findByTitleAndDesc(String keyword, Pageable pageable);

    @Query("{\n" +
            "    \"function_score\": {\n" +
            "      \"query\": {\n" +
            "        \"match_all\": {}\n" +
            "      },\n" +
            "      \"functions\": [\n" +
            "        {\n" +
            "          \"script_score\": {\n" +
            "            \"script\": {\n" +
            "              \"source\": \"cosineSimilarity(params.queryVector, 'embedding') + 1.0\",\n" +
            "              \"params\": {\n" +
            "                \"queryVector\": \n " +
            "                  ?0 \n" +
            "                \n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      ],\n" +
            "      \"score_mode\": \"sum\",\n" +
            "      \"boost_mode\": \"multiply\"\n" +
            "    }\n" +
            "}")
    List<ItemEntity> searchWithVector(List<Double> queryVector);


}
