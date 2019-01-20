package com.ireland.shortner.url.controller;

import com.ireland.shortner.url.dto.GenericResponse;
import com.ireland.shortner.url.dto.NewUrlRequest;
import com.ireland.shortner.url.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UrlShortController
{
    @Autowired
    private UrlShortnerService urlShortnerService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<GenericResponse> newUrl(@RequestBody NewUrlRequest url) throws IllegalArgumentException
    {
        if (url == null)
            throw new IllegalArgumentException("Url request cannot be null");

        if (url.getUrl() == null || url.getUrl().trim() == "")
            throw new IllegalArgumentException("Url cannot be null or empty");

        GenericResponse response = GenericResponse.newResponse(urlShortnerService.newUrl(url.getUrl()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public RedirectView moveTo(@PathVariable(name = "id") String id) throws IllegalArgumentException
    {
        try
        {
            if (id == null)
                throw new IllegalArgumentException("Id cannot be null");

            String url = urlShortnerService.findById(id);

            RedirectView redirectView = new RedirectView();
            redirectView.setUrl(url);

            return redirectView;
        }
        catch (IllegalArgumentException illegal)
        {
            illegal.printStackTrace();
            throw illegal;
        }
    }
}
