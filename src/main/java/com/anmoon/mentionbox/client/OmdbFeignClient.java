package com.anmoon.mentionbox.client;

import com.anmoon.mentionbox.dto.response.ItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdb", url = "http://www.omdbapi.com/")
public interface OmdbFeignClient {
    @GetMapping("/")
    ItemResponse getMovieDetails(
            @RequestParam("apikey") String apiKey,
            @RequestParam("t") String title
    );
}

