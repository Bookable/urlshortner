package com.ireland.shortner.url.singleton;

import com.ireland.shortner.url.model.UrlVisit;

import java.util.HashMap;

public class Orchestrator
{
    private static Orchestrator instance = new Orchestrator();

    public static Orchestrator getInstance()
    {
        return instance;
    }

    private HashMap<String, UrlVisit> idToUrl;

    private HashMap<String, String> urlToId;

    public HashMap<String, UrlVisit> getIdToUrl()
    {
        if (this.idToUrl == null)
            this.idToUrl = new HashMap<>();

        return this.idToUrl;
    }

    public HashMap<String, String> getUrlToId()
    {
        if (this.urlToId == null)
            this.urlToId= new HashMap<>();

        return this.urlToId;
    }
}
