package com.ireland.shortner.url.service;

public interface UrlShortnerService
{
    String newUrl(String url);

    String findById(String id) throws IllegalArgumentException;
}
