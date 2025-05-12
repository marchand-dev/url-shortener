package com.marchanddev.urlshortener.infrastructure.repositories;

import com.marchanddev.urlshortener.infrastructure.entities.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaShortUrlRepository extends JpaRepository<ShortUrlEntity, Integer> {
    Optional<ShortUrlEntity> findByShortUrl(String shortUrl);
}
