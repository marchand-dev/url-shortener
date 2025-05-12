package com.marchanddev.urlshortener.core.models;

import java.time.ZonedDateTime;

public class ShortUrl {

    private int id;
    private String shortUrl;
    private String originalUrl;
    private int accessCount;
    private ZonedDateTime createdAt;

    public ShortUrl() {
    }

    public ShortUrl(int id, String shortUrl, String originalUrl, int accessCount, ZonedDateTime createdAt) {
        this.id = id;
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
        this.accessCount = accessCount;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
