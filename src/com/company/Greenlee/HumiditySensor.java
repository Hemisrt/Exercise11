package com.company.Greenlee;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class HumiditySensor implements WeatherDataSource {
    private double currentHumidity;
    private List<WeatherDataListener> listeners = new ArrayList<>();

    HumiditySensor() {
        updateHumidity();
    }

    public double getCurrentHumidity() {
        return currentHumidity;
    }

    private void updateHumidity() {
        // read from humidity sensor
        currentHumidity = new Random().nextDouble() * 100;
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(WeatherDataListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void update() {
        System.out.println("HumiditySensor: getting new data.");
        updateHumidity();
        for (WeatherDataListener listener : listeners) {
            listener.updateData(new WeatherData("humidity", currentHumidity) {
                @Override
                public String getUpdateMessage() {
                    return "Humidity updated to " + currentHumidity + " %";
                }
            });
        }
    }
}