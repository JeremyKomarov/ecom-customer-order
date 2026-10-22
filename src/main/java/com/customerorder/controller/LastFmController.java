package com.customerorder.controller;

import com.customerorder.lastFm.LastFmService;
import com.customerorder.lastFm.LastFmTopTracksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class LastFmController {

    @Autowired
    LastFmService lastFmService;

    @GetMapping("/{artistName}")
    LastFmTopTracksResponse getTopTracksByArtistName(@PathVariable String artistName) {
        return lastFmService.getTopTracksByArtistName(artistName);
    }
}
