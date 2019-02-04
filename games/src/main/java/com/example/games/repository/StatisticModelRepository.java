package com.example.games.repository;

import com.example.games.model.StatisticModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatisticModelRepository extends JpaRepository<StatisticModel, Long> {

    @Query(value = "SELECT * from stat_model ORDER BY id desc limit 10", nativeQuery = true)
    List<StatisticModel> findLastTen();

}

