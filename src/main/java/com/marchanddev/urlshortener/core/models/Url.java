package com.marchanddev.urlshortener.core.models;

public class Url {

    private String url;

    public Url() {
    }

    public Url(String alias) {
        url = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
