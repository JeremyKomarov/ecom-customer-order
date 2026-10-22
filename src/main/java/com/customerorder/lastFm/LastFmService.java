package com.customerorder.lastFm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "lastFmService",
        url = "${externalApi.lastFm.url}"
)
public interface LastFmService {
    @GetMapping("/?method=artist.gettoptracks&artist={artistName}&api_key=${externalApi.lastFm.apiKey}&format=json")
    LastFmTopTracksResponse getTopTracksByArtistName(@PathVariable String artistName);
}