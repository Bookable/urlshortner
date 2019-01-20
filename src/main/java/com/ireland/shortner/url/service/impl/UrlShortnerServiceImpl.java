package com.ireland.shortner.url.service.impl;

import com.ireland.shortner.url.helper.AlphaNumeric;
import com.ireland.shortner.url.model.UrlVisit;
import com.ireland.shortner.url.service.UrlShortnerService;
import com.ireland.shortner.url.singleton.Orchestrator;
import org.springframework.stereotype.Service;

@Service
public class UrlShortnerServiceImpl implements UrlShortnerService
{
    private final int ALPHA_COUNT = 7;

    public String newUrl(String url)
    {
        String exists = Orchestrator.getInstance().getUrlToId().get(url);
        if (exists != null)
        {
            Orchestrator.getInstance().getIdToUrl().get(exists).addVisits();

            return exists;
        }

        String id = AlphaNumeric.randomAlphaNumeric(ALPHA_COUNT);
        Orchestrator.getInstance().getUrlToId().put(url, id);
        Orchestrator.getInstance().getIdToUrl().put(id, new UrlVisit(url));

        return id;
    }

    public String findById(String id) throws IllegalArgumentException
    {
        UrlVisit url = Orchestrator.getInstance().getIdToUrl().get(id);
        if (url != null)
            return url.getUrl();

        throw new IllegalArgumentException("No url found with id: " + id);
    }
}
