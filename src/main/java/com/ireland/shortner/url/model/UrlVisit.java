package com.ireland.shortner.url.model;

import java.io.Serializable;

public class UrlVisit implements Serializable
{
    public UrlVisit(String url)
    {
        this.url = url;
        this.visits = 1;
    }

    private String url;

    private Integer visits;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Integer getVisits()
    {
        return visits;
    }

    public void addVisits()
    {
        if (this.visits == null)
            this.visits = 0;

        this.visits += 1;
    }
}
