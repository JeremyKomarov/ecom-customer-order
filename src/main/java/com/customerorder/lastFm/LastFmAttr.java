package com.customerorder.lastFm;

public class LastFmAttr {
    private String artist;
    private String page;
    private String perPage;
    private String totalPages;
    private String total;

    public LastFmAttr(String artist, String page, String perPage, String totalPages, String total) {
        this.artist = artist;
        this.page = page;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.total = total;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getPage() {
        return this.page;
    }

    public String getPerPage() {
        return this.perPage;
    }

    public String getTotalPages() {
        return this.totalPages;
    }

    public String getTotal() {
        return this.total;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
