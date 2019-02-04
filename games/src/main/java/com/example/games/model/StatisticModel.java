package com.example.games.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "stat_model")
public class StatisticModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String chartName;

    @Column
    private String GBP;

    @Column
    private String USD;

    @Column
    private String time;

    @Column
    private String disclaimer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public String getGBP() {
        return GBP;
    }

    public void setGBP(String GBP) {
        this.GBP = GBP;
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticModel that = (StatisticModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(chartName, that.chartName) &&
                Objects.equals(GBP, that.GBP) &&
                Objects.equals(USD, that.USD) &&
                Objects.equals(time, that.time) &&
                Objects.equals(disclaimer, that.disclaimer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chartName, GBP, USD, time, disclaimer);
    }

    @Override
    public String toString() {
        return "StatisticModel{" +
                "id=" + id +
                ", chartName='" + chartName + '\'' +
                ", GBP='" + GBP + '\'' +
                ", USD='" + USD + '\'' +
                ", time='" + time + '\'' +
                ", disclaimer='" + disclaimer + '\'' +
                '}';
    }
}
