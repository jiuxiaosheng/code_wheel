package com.acvoli.learning.design_mode.facade;

class Facade {
  private SubSystem subSystem = new SubSystem();

  void watchMovie() {
    subSystem.turnOnTV();
    subSystem.setCD("a movie");
    subSystem.startWatching();
  }
}
