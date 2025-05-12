package com.marchanddev.urlshortener.core.usecases.impl;

import com.marchanddev.urlshortener.core.exceptions.ShortUrlNotFoundException;
import com.marchanddev.urlshortener.core.gateways.ShortUrlRepositoryGateway;
import com.marchanddev.urlshortener.core.models.ShortUrl;
import com.marchanddev.urlshortener.core.models.Url;
import com.marchanddev.urlshortener.core.usecases.GetUrlStatsUseCase;

import java.util.Optional;

public class GetUrlStatsUseCaseImpl implements GetUrlStatsUseCase {

    private ShortUrlRepositoryGateway shortUrlRepositoryGateway;

    public GetUrlStatsUseCaseImpl(ShortUrlRepositoryGateway shortUrlRepositoryGateway) {
        this.shortUrlRepositoryGateway = shortUrlRepositoryGateway;
    }

    @Override
    public ShortUrl execute(Url url) throws ShortUrlNotFoundException {
        Optional<ShortUrl> optional = shortUrlRepositoryGateway.findByShortUrl(url.getUrl());

        if (optional.isEmpty()) {
            String s = String.format("url não encontrada para alias: %s", url.getUrl());
            throw new ShortUrlNotFoundException(s);
        }

        return optional.get();
    }
}
