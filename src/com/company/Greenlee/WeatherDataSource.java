package com.company.Greenlee;

public interface WeatherDataSource {
    void addListener(WeatherDataListener listener);
    void removeListener(WeatherDataListener listener);
    void update();
}