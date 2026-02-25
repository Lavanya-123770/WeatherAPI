package com.example.Weather.controller;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Weather.entity.Weather;
import com.example.Weather.service.WeatherCsvService;
import com.example.Weather.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherCsvService csvService;
    private final WeatherService service;

    public WeatherController(WeatherCsvService csvService,
                             WeatherService service) {
        this.csvService = csvService;
        this.service = service;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        csvService.uploadCsv(file);
        return "CSV uploaded successfully!";
    }

    @GetMapping("/date")
    public List<Weather> getByDateRange(
            @RequestParam String start,
            @RequestParam String end) {

        return service.getByDateRange(
                LocalDateTime.parse(start),
                LocalDateTime.parse(end)
        );
    }

    @GetMapping("/stats")
    public Map<Integer, Map<String, Double>> getStats(@RequestParam int year) {
        return service.getMonthlyStats(year);
    }
}
