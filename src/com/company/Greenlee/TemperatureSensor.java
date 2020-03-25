package com.company.Greenlee;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TemperatureSensor implements WeatherDataSource {
    private double currentTemperature;
    private List<WeatherDataListener> listeners = new ArrayList<>();

    TemperatureSensor() {
        updateTemperature();
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    private void updateTemperature() {
        // read from humidity sensor
        currentTemperature = new Random().nextDouble() * 100;
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
        System.out.println("TemperatureSensor: getting new data.");
        updateTemperature();
        for (WeatherDataListener listener : listeners) {
            listener.updateData(new WeatherData("temperature", currentTemperature) {
                @Override
                public String getUpdateMessage() {
                    return "The new temperature is " + currentTemperature + " °C";
                }
            });
        }
    }
}