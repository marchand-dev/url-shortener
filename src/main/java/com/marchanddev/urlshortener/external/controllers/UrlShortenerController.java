package com.marchanddev.urlshortener.external.controllers;

import com.marchanddev.urlshortener.core.models.ShortUrl;
import com.marchanddev.urlshortener.core.models.Url;
import com.marchanddev.urlshortener.core.exceptions.ShortUrlAlreadyExistsException;
import com.marchanddev.urlshortener.core.exceptions.ShortUrlNotFoundException;
import com.marchanddev.urlshortener.core.usecases.RetrieveUrlUseCase;
import com.marchanddev.urlshortener.core.usecases.ShortenUrlUseCase;
import com.marchanddev.urlshortener.core.usecases.impl.ShortenUrlUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UrlShortenerController {

    @Autowired
    private ShortenUrlUseCase shortenUrlUseCase;
    @Autowired
    private RetrieveUrlUseCase retrieveUrlUseCase;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody Url url) {
        try {
            ShortUrl shortUrl = shortenUrlUseCase.execute(url);
            return ResponseEntity.ok(shortUrl.getShortUrl());
        } catch (ShortUrlAlreadyExistsException | NoSuchAlgorithmException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/{alias}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String alias) {
        try {
            ShortUrl shortUrl = retrieveUrlUseCase.execute(new Url(alias));
            URI redirectUri = URI.create(shortUrl.getOriginalUrl());
            return ResponseEntity.status(HttpStatus.FOUND).location(redirectUri).build();
        } catch (ShortUrlNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/stats/{alias}")
    public ResponseEntity<Map<String, Object>> getUrlStats(@PathVariable String alias) {
        try {
            //TODO: linha abaixo incrementa acesso em cada leitura de stats, isso é errado e precisa ser corrigido
            //ShortUrl shortUrl = urlShortenerServiceOld.retrieveUrl(new Url(alias));
            ShortUrl shortUrl = retrieveUrlUseCase.execute(new Url(alias));
            Map<String, Object> stats = new HashMap<>();
            stats.put("originalUrl", shortUrl.getOriginalUrl());
            stats.put("createdAt", shortUrl.getCreatedAt());
            stats.put("accessCount", shortUrl.getAccessCount());
            return ResponseEntity.ok(stats);
        } catch (ShortUrlNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
