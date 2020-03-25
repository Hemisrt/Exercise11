package com.company.Greenlee;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class PressureSensor implements WeatherDataSource {
    private double currentPressure;
    private List<WeatherDataListener> listeners = new ArrayList<>();

    PressureSensor() {
        updatePressure();
    }

    public double getCurrentPressure() {
        return currentPressure;
    }

    private void updatePressure() {
        // read from humidity sensor
        currentPressure = new Random().nextDouble() * 1000;
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
        System.out.println("PressureSensor: getting new data.");
        updatePressure();
        for (WeatherDataListener listener : listeners) {
            listener.updateData(new WeatherData("pressure", currentPressure) {
                @Override
                public String getUpdateMessage() {
                    return "Pressure updated to " + currentPressure + " mb";
                }
            });
        }
    }
}