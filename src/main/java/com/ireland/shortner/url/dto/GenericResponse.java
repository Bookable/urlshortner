package com.ireland.shortner.url.dto;

import java.io.Serializable;

public class GenericResponse implements Serializable
{
    public GenericResponse()
    {

    }

    public GenericResponse(String response)
    {
        this.response = response;
    }

    public static GenericResponse newResponse(String value)
    {
        return new GenericResponse(value);
    }

    private String response;

    public String getResponse()
    {
        return response;
    }

    public void setResponse(String response)
    {
        this.response = response;
    }
}
