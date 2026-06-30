package com.anunya.url_shortener.service;

import com.anunya.url_shortener.dto.CreateShortUrlRequest;
import com.anunya.url_shortener.dto.CreateShortUrlResponse;

public interface UrlService {

    CreateShortUrlResponse createShortUrl(CreateShortUrlRequest request);

    String getLongUrl(String shortCode);
}