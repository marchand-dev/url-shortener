package com.marchanddev.urlshortener.external.config;

import com.marchanddev.urlshortener.core.usecases.GetUrlStatsUseCase;
import com.marchanddev.urlshortener.core.usecases.RetrieveUrlUseCase;
import com.marchanddev.urlshortener.core.usecases.ShortenUrlUseCase;
import com.marchanddev.urlshortener.core.usecases.impl.GetUrlStatsUseCaseImpl;
import com.marchanddev.urlshortener.core.usecases.impl.RetrieveUrlUseCaseImpl;
import com.marchanddev.urlshortener.core.usecases.impl.ShortenUrlUseCaseImpl;
import com.marchanddev.urlshortener.external.repositories.ShortUrlRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    public ShortenUrlUseCase shortenUrlUseCase(ShortUrlRepository shortUrlRepository) {
        return new ShortenUrlUseCaseImpl(shortUrlRepository);
    }

    @Bean
    public RetrieveUrlUseCase retrieveUrlUseCase(ShortUrlRepository shortUrlRepository) {
        return new RetrieveUrlUseCaseImpl(shortUrlRepository);
    }

    @Bean
    public GetUrlStatsUseCase getUrlStatsUseCase(ShortUrlRepository shortUrlRepository) {
        return new GetUrlStatsUseCaseImpl(shortUrlRepository);
    }
}
