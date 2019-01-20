package com.ireland.shortner.url.controller;

import com.ireland.shortner.url.model.UrlVisit;
import com.ireland.shortner.url.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StatisticController
{
    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "/statistic/more/visited", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UrlVisit>> moreVisited() throws IllegalArgumentException
    {
        //Actually it is supposed to be a DTO
        List<UrlVisit> list = statisticService.getMoreVisited();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
