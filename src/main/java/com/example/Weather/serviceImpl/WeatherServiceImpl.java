package com.example.Weather.serviceImpl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Weather.entity.Weather;
import com.example.Weather.repository.WeatherRepository;
import com.example.Weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Weather> getByDateRange(LocalDateTime start, LocalDateTime end) {
        return repository.findByDatetimeUtcBetween(start, end);
    }

    @Override
    public Map<Integer, Map<String, Double>> getMonthlyStats(int year) {

        LocalDateTime start = LocalDateTime.of(year, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(year, 12, 31, 23, 59);

        List<Weather> data =
                repository.findByDatetimeUtcBetween(start, end);

        Map<Integer, List<Double>> monthTemperatureMap = data.stream()
                .filter(w -> w.getTemperature() != null)
                .collect(Collectors.groupingBy(
                        w -> w.getDatetimeUtc().getMonthValue(),
                        Collectors.mapping(Weather::getTemperature, Collectors.toList())
                ));

        Map<Integer, Map<String, Double>> result = new HashMap<>();

        for (Map.Entry<Integer, List<Double>> entry : monthTemperatureMap.entrySet()) {

            List<Double> temps = entry.getValue();
            Collections.sort(temps);

            double min = temps.get(0);
            double max = temps.get(temps.size() - 1);
            double median;

            int size = temps.size();
            if (size % 2 == 0) {
                median = (temps.get(size/2 - 1) + temps.get(size/2)) / 2;
            } else {
                median = temps.get(size/2);
            }

            Map<String, Double> stats = new HashMap<>();
            stats.put("min", min);
            stats.put("max", max);
            stats.put("median", median);

            result.put(entry.getKey(), stats);
        }

        return result;
    }
}