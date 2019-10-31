package com.acvoli.learning.design_mode.command;

class LightOffCommand implements Command {
  Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();
  }
}
