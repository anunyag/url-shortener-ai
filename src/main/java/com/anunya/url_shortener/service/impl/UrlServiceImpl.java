package com.anunya.url_shortener.service.impl;

import com.anunya.url_shortener.dto.CreateShortUrlRequest;
import com.anunya.url_shortener.dto.CreateShortUrlResponse;
import com.anunya.url_shortener.entity.Url;
import com.anunya.url_shortener.repository.UrlRepository;
import com.anunya.url_shortener.service.UrlService;
import com.anunya.url_shortener.util.ShortCodeGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public CreateShortUrlResponse createShortUrl(CreateShortUrlRequest request) {

        String shortCode = generateUniqueShortCode();

        Url url = new Url();
        url.setLongUrl(request.getLongUrl());
        url.setShortCode(shortCode);
        url.setCreatedAt(LocalDateTime.now());

        urlRepository.save(url);

        return new CreateShortUrlResponse(
                shortCode,
                "http://localhost:8080/" + shortCode
        );
    }

    private String generateUniqueShortCode() {

        String code;

        do {
            code = ShortCodeGenerator.generate();
        } while (urlRepository.existsByShortCode(code));

        return code;
    }
    @Override
public String getLongUrl(String shortCode) {

    Url url = urlRepository.findByShortCode(shortCode)
            .orElseThrow(() -> new RuntimeException("Short URL not found"));

    return url.getLongUrl();
}
}