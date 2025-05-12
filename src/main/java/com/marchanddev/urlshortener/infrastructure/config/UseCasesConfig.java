package com.marchanddev.urlshortener.infrastructure.config;

import com.marchanddev.urlshortener.core.gateways.ShortUrlRepositoryGateway;
import com.marchanddev.urlshortener.core.usecases.GetUrlStatsUseCase;
import com.marchanddev.urlshortener.core.usecases.RetrieveUrlUseCase;
import com.marchanddev.urlshortener.core.usecases.ShortenUrlUseCase;
import com.marchanddev.urlshortener.core.usecases.impl.GetUrlStatsUseCaseImpl;
import com.marchanddev.urlshortener.core.usecases.impl.RetrieveUrlUseCaseImpl;
import com.marchanddev.urlshortener.core.usecases.impl.ShortenUrlUseCaseImpl;
import com.marchanddev.urlshortener.infrastructure.repositories.JpaShortUrlRepository;
import com.marchanddev.urlshortener.infrastructure.repositories.impl.ShortUrlRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    public ShortUrlRepositoryGateway shortUrlRepositoryGateway(JpaShortUrlRepository jpaShortUrlRepository) {
        return new ShortUrlRepositoryImpl();
    }

    @Bean
    public ShortenUrlUseCase shortenUrlUseCase(ShortUrlRepositoryGateway shortUrlRepositoryGateway) {
        return new ShortenUrlUseCaseImpl(shortUrlRepositoryGateway);
    }

    @Bean
    public RetrieveUrlUseCase retrieveUrlUseCase(ShortUrlRepositoryGateway shortUrlRepositoryGateway) {
        return new RetrieveUrlUseCaseImpl(shortUrlRepositoryGateway);
    }

    @Bean
    public GetUrlStatsUseCase getUrlStatsUseCase(ShortUrlRepositoryGateway shortUrlRepositoryGateway) {
        return new GetUrlStatsUseCaseImpl(shortUrlRepositoryGateway);
    }
}
