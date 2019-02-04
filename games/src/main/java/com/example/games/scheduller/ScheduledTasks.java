package com.example.games.scheduller;

import com.example.games.connection.HttpConnection;
import com.example.games.model.StatisticModel;
import com.example.games.service.StatisticService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private StatisticService statisticService;

    //fixedRate in milliseconds
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("Making https request...");
        try {
            JSONObject jsonObject = HttpConnection.getJson("https://api.coindesk.com/v1/bpi/currentprice.json?t=123454");
            log.info(jsonObject.toString());
            String disclaimer = jsonObject.getString("disclaimer");
            String chartName = jsonObject.getString("chartName");
            String GBP = jsonObject.getJSONObject("bpi").getJSONObject("GBP").getString("rate_float");
            String USD = jsonObject.getJSONObject("bpi").getJSONObject("USD").getString("rate");
            String time = jsonObject.getJSONObject("time").getString("updated");
            //Process data with any rules (modify input value, add additional values)
            if (chartName.equalsIgnoreCase("Bitcoin")) {
                chartName = chartName + " GameSys version";
            }
            Double GBPDouble = new Double(GBP);
            GBPDouble = GBPDouble * 0.1;
            StatisticModel s = new StatisticModel();
            s.setChartName(chartName);
            s.setDisclaimer(disclaimer);
            s.setGBP(GBPDouble.toString());
            s.setUSD(USD);
            s.setTime(time);
            log.info("saving statistic to database...");
            statisticService.save(s);
        } catch (Exception e) {
            log.error("ScheduledTasks reportCurrentTime exception occurred");
            e.printStackTrace();
        }
    }
}
