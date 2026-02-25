package com.example.Weather.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Weather.entity.Weather;

public interface WeatherService {

    List<Weather> getByDateRange(LocalDateTime start, LocalDateTime end);

    Map<Integer, Map<String, Double>> getMonthlyStats(int year);
}