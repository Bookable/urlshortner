package com.ireland.shortner.url.service;

import com.ireland.shortner.url.model.UrlVisit;

import java.util.List;

public interface StatisticService
{
    List<UrlVisit> getMoreVisited();
}
