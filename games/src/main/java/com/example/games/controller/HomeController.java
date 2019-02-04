package com.example.games.controller;

import com.example.games.model.StatisticModel;
import com.example.games.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/")
    public List<StatisticModel> getStatistic(){
        return statisticService.findLastTen();
    }
}
