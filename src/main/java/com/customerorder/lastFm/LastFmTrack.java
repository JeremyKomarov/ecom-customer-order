package com.customerorder.lastFm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LastFmTrack {
    private String name;
    private String playcount;
    private String listeners;
    private String mbid;
    private String url;
    private String streamable;
    private LastFmTrackArtist artist;
    private List<LastFmTrackImage> image;
    @JsonProperty("@attr")
    private LastFmTrackAttr attr;

    public LastFmTrack(String name, String playcount, String listeners, String mbid, String url, String streamable, LastFmTrackArtist artist, List<LastFmTrackImage> image, LastFmTrackAttr attr) {
        this.name = name;
        this.playcount = playcount;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.artist = artist;
        this.image = image;
        this.attr = attr;
    }

    public String getName() {
        return this.name;
    }

    public String getPlaycount() {
        return this.playcount;
    }

    public String getListeners() {
        return this.listeners;
    }

    public String getMbid() {
        return this.mbid;
    }

    public String getUrl() {
        return this.url;
    }

    public String getStreamable() {
        return this.streamable;
    }

    public LastFmTrackArtist getArtist() {
        return this.artist;
    }

    public List<LastFmTrackImage> getImage() {
        return this.image;
    }

    public LastFmTrackAttr getAttr() {
        return this.attr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public void setArtist(LastFmTrackArtist artist) {
        this.artist = artist;
    }

    public void setImage(List<LastFmTrackImage> image) {
        this.image = image;
    }

    public void setAttr(LastFmTrackAttr attr) {
        this.attr = attr;
    }
}
