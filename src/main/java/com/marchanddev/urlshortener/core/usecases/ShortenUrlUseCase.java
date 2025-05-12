package com.marchanddev.urlshortener.core.usecases;

import com.marchanddev.urlshortener.core.exceptions.CantCreateAliasException;
import com.marchanddev.urlshortener.core.exceptions.ShortUrlAlreadyExistsException;
import com.marchanddev.urlshortener.core.models.ShortUrl;
import com.marchanddev.urlshortener.core.models.Url;

public interface ShortenUrlUseCase {
    ShortUrl execute(Url url) throws CantCreateAliasException, ShortUrlAlreadyExistsException;
}
