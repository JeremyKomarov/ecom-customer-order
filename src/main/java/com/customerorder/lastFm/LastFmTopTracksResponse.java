package com.customerorder.lastFm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastFmTopTracksResponse {

    @JsonProperty("toptracks")
    LastFmTopTracks topTracks;

    public LastFmTopTracksResponse(LastFmTopTracks topTracks) {
        this.topTracks = topTracks;
    }

    public LastFmTopTracks getTopTracks() {
        return this.topTracks;
    }

    public void setTopTracks(LastFmTopTracks topTracks) {
        this.topTracks = topTracks;
    }
}
