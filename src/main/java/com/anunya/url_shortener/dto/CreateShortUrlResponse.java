package com.anunya.url_shortener.dto;

public class CreateShortUrlResponse {

    private String shortCode;
    private String shortUrl;

    public CreateShortUrlResponse() {
    }

    public CreateShortUrlResponse(String shortCode, String shortUrl) {
        this.shortCode = shortCode;
        this.shortUrl = shortUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}