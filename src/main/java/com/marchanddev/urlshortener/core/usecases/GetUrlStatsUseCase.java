package com.marchanddev.urlshortener.core.usecases;

import com.marchanddev.urlshortener.core.exceptions.ShortUrlNotFoundException;
import com.marchanddev.urlshortener.core.models.ShortUrl;
import com.marchanddev.urlshortener.core.models.Url;

public interface GetUrlStatsUseCase {

    ShortUrl execute(Url url) throws ShortUrlNotFoundException;

}
