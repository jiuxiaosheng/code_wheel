package com.acvoli.learning.design_mode.observer;

/** 定义对象之间的一对多依赖，当一个对象状态改变时，它的所有依赖都会收到通知并且自动更新状态。 主题（Subject）是被观察的对象，而其所有依赖者（Observer）称为观察者。 */
class WeatherStation {
  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();
    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

    weatherData.setMeasurements(0, 0, 0);
    weatherData.setMeasurements(1, 1, 1);
  }
}
