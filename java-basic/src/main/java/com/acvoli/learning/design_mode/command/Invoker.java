package com.acvoli.learning.design_mode.command;

class Invoker {
  private Command[] onCommands;
  private Command[] offCommands;
  private final int slotNum = 7;

  public Invoker() {
    this.onCommands = new Command[slotNum];
    this.onCommands = new Command[slotNum];
  }

  public void setOnCommand(Command command, int slot) {
    onCommands[slot] = command;
  }

  public void setOffCommand(Command command, int slot) {
    offCommands[slot] = command;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
  }
}
