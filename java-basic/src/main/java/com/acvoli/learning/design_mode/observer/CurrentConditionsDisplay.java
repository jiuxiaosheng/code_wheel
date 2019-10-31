package com.acvoli.learning.design_mode.observer;

class CurrentConditionsDisplay implements Observer {

  public CurrentConditionsDisplay(WeatherData weatherData) {
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    System.out.println(
        "CurrentConditionsDisplay.update: " + temp + " " + humidity + " " + pressure);
  }
}
