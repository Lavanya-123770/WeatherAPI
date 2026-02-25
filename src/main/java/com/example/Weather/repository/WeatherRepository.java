package com.example.Weather.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Weather.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather , Long>{
	 List<Weather> findByDatetimeUtcBetween(LocalDateTime start, LocalDateTime end);

}
