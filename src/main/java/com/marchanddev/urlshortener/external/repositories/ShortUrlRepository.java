package com.marchanddev.urlshortener.external.repositories;

import com.marchanddev.urlshortener.core.gateways.ShortUrlRepositoryGateway;
import com.marchanddev.urlshortener.core.models.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer>, ShortUrlRepositoryGateway {
    Optional<ShortUrl> findByShortUrl(String shortUrl);
}
