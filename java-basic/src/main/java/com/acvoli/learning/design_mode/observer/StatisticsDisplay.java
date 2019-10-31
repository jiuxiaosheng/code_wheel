package com.acvoli.learning.design_mode.observer;

class StatisticsDisplay implements Observer {

  public StatisticsDisplay(Subject weatherData) {
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    System.out.println("StatisticsDisplay.update: " + temp + " " + humidity + " " + pressure);
  }
}
