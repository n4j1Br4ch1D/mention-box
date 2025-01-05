package com.anmoon.mentionbox.entity;

import com.anmoon.mentionbox.dto.response.Rating;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(indexName = "items")
//@Document(indexName="javatechie",type="customer",shards=2)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemEntity {
    private Long id;
    private String title;
    private String desc;

//    private String year;
//    private String rated;
//    private String released;
//    private String season;
//    private String episode;
//    private String runtime;
//    private String genre;
//    private String director;
//    private String writer;
//    private String actors;
//    private String plot;
//    private String language;
//    private String country;
//    private String awards;
//    private String poster;
//    private ArrayList<Rating> ratings;
//    private String metaScore;
//    private String imdbRating;
//    private String imdbVotes;
//    private String imdbID;
//    private String seriesID;
//    private String type;
//    private String response;
//    private String totalSeasons;
//    private String dvd;
//    private String boxOffice;
//    private String production;
//    private String website;

//    private List<SubtitleEntity> subtitles;
}
