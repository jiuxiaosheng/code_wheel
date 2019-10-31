package com.acvoli.learning.design_mode.observer;

interface Subject {
  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObserver();
}
