package com.marchanddev.urlshortener.infrastructure.repositories.impl;

import com.marchanddev.urlshortener.core.gateways.ShortUrlRepositoryGateway;
import com.marchanddev.urlshortener.core.models.ShortUrl;
import com.marchanddev.urlshortener.infrastructure.entities.ShortUrlEntity;
import com.marchanddev.urlshortener.infrastructure.mappers.ShortUrlMapper;
import com.marchanddev.urlshortener.infrastructure.repositories.JpaShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShortUrlRepositoryImpl implements ShortUrlRepositoryGateway {

    @Autowired
    private JpaShortUrlRepository jpaRepository;

    @Override
    public ShortUrl save(ShortUrl shortUrl) {
        ShortUrlEntity entity = ShortUrlMapper.toEntity(shortUrl);
        ShortUrlEntity saved = jpaRepository.save(entity);
        return ShortUrlMapper.toModel(saved);
    }

    @Override
    public Optional<ShortUrl> findByShortUrl(String shortUrl) {
        return jpaRepository.findByShortUrl(shortUrl)
                .map(ShortUrlMapper::toModel);
    }
}