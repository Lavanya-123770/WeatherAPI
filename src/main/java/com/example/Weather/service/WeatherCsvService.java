package com.example.Weather.service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Weather.entity.Weather;
import com.example.Weather.repository.WeatherRepository;
import com.opencsv.CSVReader;

@Service
public class WeatherCsvService {

    private final WeatherRepository repository;

    public WeatherCsvService(WeatherRepository repository) {
        this.repository = repository;
    }

    public void uploadCsv(MultipartFile file) {

        try (Reader reader = new InputStreamReader(file.getInputStream());
             CSVReader csvReader = new CSVReader(reader)) {

            String[] row;

           
            csvReader.readNext();

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");

            List<Weather> weatherList = new ArrayList<>();

            while ((row = csvReader.readNext()) != null) {

                Weather weather = new Weather();

                // Date
                weather.setDatetimeUtc(
                        LocalDateTime.parse(row[0], formatter)
                );

                weather.setCondition(row[1]);
                weather.setDewPoint(parseDouble(row[2]));
                weather.setFog(parseInt(row[3]));
                weather.setHail(parseInt(row[4]));
                weather.setHeatIndex(parseDouble(row[5]));
                weather.setHumidity(parseDouble(row[6]));
                weather.setPrecipitation(parseDouble(row[7]));
                weather.setPressure(parseDouble(row[8]));
                weather.setRain(parseInt(row[9]));
                weather.setSnow(parseInt(row[10]));
                weather.setTemperature(parseDouble(row[11]));
                weather.setThunder(parseInt(row[12]));
                weather.setTornado(parseInt(row[13]));
                weather.setVisibility(parseDouble(row[14]));
                weather.setWindDirectionDegree(parseDouble(row[15]));
                weather.setWindDirection(row[16]);
                weather.setWindGust(parseDouble(row[17]));
                weather.setWindChill(parseDouble(row[18]));
                weather.setWindSpeed(parseDouble(row[19]));

                weatherList.add(weather);
            }

           
            repository.saveAll(weatherList);

        } catch (Exception e) {
            throw new RuntimeException("Error processing CSV", e);
        }
    }

   

    private Double parseDouble(String value) {
        try {
            return (value == null || value.isBlank()) ? null : Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }

    private Integer parseInt(String value) {
        try {
            return (value == null || value.isBlank()) ? null : Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
}