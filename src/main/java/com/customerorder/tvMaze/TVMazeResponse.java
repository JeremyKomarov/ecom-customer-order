package com.customerorder.tvMaze;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TVMazeResponse {

    private Long id;

    @JsonProperty("url")
    private String imageUrl;

    private String name;

    public TVMazeResponse(Long id, String imageUrl, String name) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }
}
