package com.company.Greenlee;

abstract class WeatherData {
    private String dataType;
    private Double measuredValue;

    WeatherData(String dataType, Double measuredValue) {
        this.dataType = dataType;
        this.measuredValue = measuredValue;
    }

    public String getDataType() {
        return dataType;
    }

    public Double getMeasuredValue() {
        return measuredValue;
    }

    abstract public String getUpdateMessage();
}