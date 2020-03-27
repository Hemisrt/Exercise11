package com.company.Greenlee;

public class Main {
    // Trenton Greenlee
    // 3/23/2020
    // Exercise 11
    public static void main(String[] args) {
        System.out.println("Main: creating objects");
        WeatherStation localWeatherStation = new WeatherStation();

        TemperatureSensor temperatureSensor = new TemperatureSensor();
        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();

        temperatureSensor.addListener(localWeatherStation);
        humiditySensor.addListener(localWeatherStation);
        pressureSensor.addListener(localWeatherStation);

        System.out.println("Main: simulating updates from sensors");
        pressureSensor.update();
        temperatureSensor.update();
        humiditySensor.update();
        pressureSensor.update();
        temperatureSensor.update();
        humiditySensor.update();

        System.out.println("Main: displaying report and logs");
        localWeatherStation.displayCurrentWeather();
        localWeatherStation.displayLog();
    }
}
