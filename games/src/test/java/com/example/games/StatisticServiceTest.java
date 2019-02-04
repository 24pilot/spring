package com.example.games;

import com.example.games.model.StatisticModel;
import com.example.games.repository.StatisticModelRepository;
import com.example.games.service.StatisticService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticServiceTest {

    @Autowired
    private StatisticService statisticService;

    @Test
    public void whenSaveExpectSavedEntity() {
        StatisticModel s = new StatisticModel();
        s.setChartName("Chart1");
        s.setDisclaimer("Disc");
        statisticService.save(s);
        List<StatisticModel> savedStatisticModels = statisticService.findLastTen();
        assertEquals(1, savedStatisticModels.size());
        StatisticModel saved = savedStatisticModels.get(0);
        assertEquals("Chart1", saved.getChartName());

    }
}
