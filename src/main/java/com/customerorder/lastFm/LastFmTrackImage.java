package com.customerorder.lastFm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastFmTrackImage {
    @JsonProperty("#text")
    private String text;
    private String size;

    public LastFmTrackImage(String text, String size) {
        this.text = text;
        this.size = size;
    }

    public String getText() {
        return this.text;
    }

    public String getSize() {
        return this.size;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
