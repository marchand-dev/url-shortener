package com.marchanddev.urlshortener.core.usecases.impl;

import com.marchanddev.urlshortener.core.exceptions.CantCreateAliasException;
import com.marchanddev.urlshortener.core.exceptions.ShortUrlAlreadyExistsException;
import com.marchanddev.urlshortener.core.gateways.ShortUrlRepositoryGateway;
import com.marchanddev.urlshortener.core.models.ShortUrl;
import com.marchanddev.urlshortener.core.models.Url;
import com.marchanddev.urlshortener.core.usecases.ShortenUrlUseCase;
import com.marchanddev.urlshortener.core.utils.Base62Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Optional;

public class ShortenUrlUseCaseImpl implements ShortenUrlUseCase {

    private static final String HASH_ALGORITHM = "MD5";
    private ShortUrlRepositoryGateway shortUrlRepositoryGateway;

    public ShortenUrlUseCaseImpl(ShortUrlRepositoryGateway repository) {
        shortUrlRepositoryGateway = repository;
    }

    @Override
    public ShortUrl execute(Url url) throws CantCreateAliasException, ShortUrlAlreadyExistsException {
        String alias = createAlias(url.getUrl());

        if (shortUrlAlreadyExists(alias)) {
            String s = String.format("alias: %s já existe. tentativa para url %s", alias, url.getUrl());
            throw new ShortUrlAlreadyExistsException(s);
        }

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setShortUrl(alias);
        shortUrl.setOriginalUrl(url.getUrl());
        shortUrl.setCreatedAt(ZonedDateTime.now());
        return shortUrlRepositoryGateway.save(shortUrl);
    }

    private String createAlias(String url) throws CantCreateAliasException {
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashBytes = md.digest(url.getBytes(StandardCharsets.UTF_8));
            byte[] firstBytes = Arrays.copyOfRange(hashBytes, 0, 6); // 6 bytes = 48 bits
            return Base62Encoder.encode(firstBytes, 7); // 7 caracteres base62 garantem boa entropia
        } catch (NoSuchAlgorithmException e) {
            throw new CantCreateAliasException(e.getMessage());
        }

    }

    private boolean shortUrlAlreadyExists(String shortUrl) {
        Optional<ShortUrl> existing = shortUrlRepositoryGateway.findByShortUrl(shortUrl);
        return existing.isPresent();
    }
}
