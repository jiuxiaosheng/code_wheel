package com.acvoli.learning.design_mode.command;

class LightOnCommand implements Command {

  Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();
  }
}
