package com.anunya.url_shortener.controller;

import com.anunya.url_shortener.dto.CreateShortUrlRequest;
import com.anunya.url_shortener.dto.CreateShortUrlResponse;
import com.anunya.url_shortener.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateShortUrlResponse createShortUrl(
            @Valid @RequestBody CreateShortUrlRequest request) {

        return urlService.createShortUrl(request);
    }
}