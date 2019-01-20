package com.ireland.shortner.url.service.impl;

import com.ireland.shortner.url.model.UrlVisit;
import com.ireland.shortner.url.service.StatisticService;
import com.ireland.shortner.url.singleton.Orchestrator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService
{
    public List<UrlVisit> getMoreVisited()
    {
        return Orchestrator.getInstance().getIdToUrl().entrySet()
                .stream()
                .map(x -> x.getValue())
                .sorted((x, y) -> Integer.compare(y.getVisits(), x.getVisits()))
                .collect(Collectors.toList());
    }
}
