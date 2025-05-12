package com.marchanddev.urlshortener.core.usecases.impl;

import com.marchanddev.urlshortener.core.exceptions.ShortUrlNotFoundException;
import com.marchanddev.urlshortener.core.gateways.ShortUrlRepositoryGateway;
import com.marchanddev.urlshortener.core.models.ShortUrl;
import com.marchanddev.urlshortener.core.models.Url;
import com.marchanddev.urlshortener.core.usecases.RetrieveUrlUseCase;

import java.util.Optional;

public class RetrieveUrlUseCaseImpl implements RetrieveUrlUseCase {

    private ShortUrlRepositoryGateway shortUrlRepositoryGateway;

    public RetrieveUrlUseCaseImpl(ShortUrlRepositoryGateway shortUrlRepositoryGateway) {
        this.shortUrlRepositoryGateway = shortUrlRepositoryGateway;
    }

    @Override
    public ShortUrl execute(Url alias) throws ShortUrlNotFoundException {
        Optional<ShortUrl> optional = shortUrlRepositoryGateway.findByShortUrl(alias.getUrl());
        if (optional.isEmpty()) {
            String s = String.format("url não encontrada para alias: %s", alias.getUrl());
            throw new ShortUrlNotFoundException(s);
        }

        ShortUrl shortUrl = optional.get();
        shortUrl.setAccessCount(shortUrl.getAccessCount() + 1);
        shortUrlRepositoryGateway.save(shortUrl);
        return shortUrl;
    }
}
