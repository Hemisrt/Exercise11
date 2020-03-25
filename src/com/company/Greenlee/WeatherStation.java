package com.company.Greenlee;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WeatherStation implements WeatherDataListener {
    private Map<String, Double> allWeatherData = new HashMap<>();
    private List<String> log = new ArrayList<>();

    @Override
    public void updateData(WeatherData newData) {
        System.out.println("WeatherStation: Updating the weather station data with new "
                + newData.getDataType() + " data.");
        allWeatherData.put(newData.getDataType(), newData.getMeasuredValue());
        log.add(newData.getUpdateMessage());
    }

    public void displayCurrentWeather() {
        System.out.println("Weather Report");
        for (String dataType: allWeatherData.keySet()) {
            System.out.println(dataType + ": " + allWeatherData.get(dataType));
        }
    }

    public void displayLog() {
        for (int i=0; i < log.size(); i++) {
            int currentLine = i + 1;
            System.out.println(currentLine + ": " + log.get(i));
        }
    }
}