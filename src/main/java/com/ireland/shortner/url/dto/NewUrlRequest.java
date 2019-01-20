package com.ireland.shortner.url.dto;

import java.io.Serializable;

public class NewUrlRequest implements Serializable
{
    private String url;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
