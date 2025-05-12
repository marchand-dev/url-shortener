package com.marchanddev.urlshortener.infrastructure.mappers;

import com.marchanddev.urlshortener.core.models.ShortUrl;
import com.marchanddev.urlshortener.infrastructure.entities.ShortUrlEntity;

public class ShortUrlMapper {
    public static ShortUrlEntity toEntity(ShortUrl model) {
        ShortUrlEntity entity = new ShortUrlEntity();
        entity.setId(model.getId());
        entity.setShortUrl(model.getShortUrl());
        entity.setOriginalUrl(model.getOriginalUrl());
        entity.setAccessCount(model.getAccessCount());
        entity.setCreatedAt(model.getCreatedAt());
        return entity;
    }

    public static ShortUrl toModel(ShortUrlEntity entity) {
        ShortUrl model = new ShortUrl();
        model.setId(entity.getId());
        model.setShortUrl(entity.getShortUrl());
        model.setOriginalUrl(entity.getOriginalUrl());
        model.setAccessCount(entity.getAccessCount());
        model.setCreatedAt(entity.getCreatedAt());
        return model;
    }
}
