package com.anmoon.mentionbox.entity;

import co.elastic.clients.elasticsearch._types.analysis.Language;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.providers.base.LanguageCode;
import org.springframework.data.elasticsearch.annotations.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(indexName = "subtitles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubtitleEntity extends BaseEntity{
    private String name;
//    private LanguageCode local;
    private String content;

//    private ItemEntity item;
}