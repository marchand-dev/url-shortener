package com.marchanddev.urlshortener.core.gateways;

import com.marchanddev.urlshortener.core.models.ShortUrl;

import java.util.Optional;

public interface ShortUrlRepositoryGateway {
    ShortUrl save(ShortUrl shortUrl);
    Optional<ShortUrl> findByShortUrl(String shortUrl);
}
