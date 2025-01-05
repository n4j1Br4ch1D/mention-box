package com.anmoon.mentionbox.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonPropertyOrder({
        "Title", "Year", "Rated", "Released", "Season", "Episode",
        "Runtime", "Genre", "Director", "Writer", "Actors", "Plot",
        "Language", "Country", "Awards", "Poster", "Ratings", "Metascore",
        "imdbRating", "imdbVotes", "imdbID", "seriesID", "Type", "Response",
        "totalSeasons", "DVD", "BoxOffice", "Production", "Website"
})
public class ItemResponse {
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Year")
    public String year;
    @JsonProperty("Rated")
    public String rated;
    @JsonProperty("Released")
    public String released;
    @JsonProperty("Season")
    public String season;
    @JsonProperty("Episode")
    public String episode;
    @JsonProperty("Runtime")
    public String runtime;
    @JsonProperty("Genre")
    public String genre;
    @JsonProperty("Director")
    public String director;
    @JsonProperty("Writer")
    public String writer;
    @JsonProperty("Actors")
    public String actors;
    @JsonProperty("Plot")
    public String plot;
    @JsonProperty("Language")
    public String language;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("Awards")
    public String awards;
    @JsonProperty("Poster")
    public String poster;
    @JsonProperty("Ratings")
    public ArrayList<Rating> ratings;
    @JsonProperty("Metascore")
    public String metaScore;
    @JsonProperty("imdbRating")
    public String imdbRating;
    @JsonProperty("imdbVotes")
    public String imdbVotes;
    @JsonProperty("imdbID")
    public String imdbID;
    @JsonProperty("seriesID")
    public String seriesID;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Response")
    public String response;
    @JsonProperty("totalSeasons")
    public String totalSeasons;
    @JsonProperty("DVD")
    public String dvd;
    @JsonProperty("BoxOffice")
    public String boxOffice;
    @JsonProperty("Production")
    public String production;
    @JsonProperty("Website")
    public String website;
}