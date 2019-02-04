package com.example.games.service;

import com.example.games.model.StatisticModel;
import com.example.games.repository.StatisticModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class StatisticService {

    @Autowired
    private StatisticModelRepository statisticModelRepository;

    @Transactional
    public void save(StatisticModel statisticModel) {
        statisticModelRepository.save(statisticModel);
    }

    public List<StatisticModel> findLastTen() {
        return statisticModelRepository.findLastTen();
    }
}
