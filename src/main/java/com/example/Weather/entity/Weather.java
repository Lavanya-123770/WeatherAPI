package com.example.Weather.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "weather_data")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datetime_utc")
    private LocalDateTime datetimeUtc;

    @Column(name = "_conds")
    private String condition;

    @Column(name = "_dewptm")
    private Double dewPoint;

    @Column(name = "_fog")
    private Integer fog;

    @Column(name = "_hail")
    private Integer hail;

    @Column(name = "_heatindexm")
    private Double heatIndex;

    @Column(name = "_hum")
    private Double humidity;

    @Column(name = "_precipm")
    private Double precipitation;

    @Column(name = "_pressurem")
    private Double pressure;

    @Column(name = "_rain")
    private Integer rain;

    @Column(name = "_snow")
    private Integer snow;

    @Column(name = "_tempm")
    private Double temperature;

    @Column(name = "_thunder")
    private Integer thunder;

    @Column(name = "_tornado")
    private Integer tornado;

    @Column(name = "_vism")
    private Double visibility;

    @Column(name = "_wdird")
    private Double windDirectionDegree;

    @Column(name = "_wdire")
    private String windDirection;

    @Column(name = "_wgustm")
    private Double windGust;

    @Column(name = "_windchillm")
    private Double windChill;

    @Column(name = "_wspdm")
    private Double windSpeed;

   

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDatetimeUtc() { return datetimeUtc; }
    public void setDatetimeUtc(LocalDateTime datetimeUtc) { this.datetimeUtc = datetimeUtc; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public Double getDewPoint() { return dewPoint; }
    public void setDewPoint(Double dewPoint) { this.dewPoint = dewPoint; }

    public Integer getFog() { return fog; }
    public void setFog(Integer fog) { this.fog = fog; }

    public Integer getHail() { return hail; }
    public void setHail(Integer hail) { this.hail = hail; }

    public Double getHeatIndex() { return heatIndex; }
    public void setHeatIndex(Double heatIndex) { this.heatIndex = heatIndex; }

    public Double getHumidity() { return humidity; }
    public void setHumidity(Double humidity) { this.humidity = humidity; }

    public Double getPrecipitation() { return precipitation; }
    public void setPrecipitation(Double precipitation) { this.precipitation = precipitation; }

    public Double getPressure() { return pressure; }
    public void setPressure(Double pressure) { this.pressure = pressure; }

    public Integer getRain() { return rain; }
    public void setRain(Integer rain) { this.rain = rain; }

    public Integer getSnow() { return snow; }
    public void setSnow(Integer snow) { this.snow = snow; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Integer getThunder() { return thunder; }
    public void setThunder(Integer thunder) { this.thunder = thunder; }

    public Integer getTornado() { return tornado; }
    public void setTornado(Integer tornado) { this.tornado = tornado; }

    public Double getVisibility() { return visibility; }
    public void setVisibility(Double visibility) { this.visibility = visibility; }

    public Double getWindDirectionDegree() { return windDirectionDegree; }
    public void setWindDirectionDegree(Double windDirectionDegree) { this.windDirectionDegree = windDirectionDegree; }

    public String getWindDirection() { return windDirection; }
    public void setWindDirection(String windDirection) { this.windDirection = windDirection; }

    public Double getWindGust() { return windGust; }
    public void setWindGust(Double windGust) { this.windGust = windGust; }

    public Double getWindChill() { return windChill; }
    public void setWindChill(Double windChill) { this.windChill = windChill; }

    public Double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(Double windSpeed) { this.windSpeed = windSpeed; }
	
}
