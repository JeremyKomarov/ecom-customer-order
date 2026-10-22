package com.customerorder.lastFm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LastFmTopTracks {
    private List<LastFmTrack> track;
    @JsonProperty("@attr")
    private LastFmAttr attr;

    public LastFmTopTracks(List<LastFmTrack> track, LastFmAttr attr) {
        this.track = track;
        this.attr = attr;
    }

    public List<LastFmTrack> getTrack() {
        return this.track;
    }

    public LastFmAttr getAttr() {
        return this.attr;
    }

    public void setTrack(List<LastFmTrack> track) {
        this.track = track;
    }

    public void setAttr(LastFmAttr attr) {
        this.attr = attr;
    }
}
