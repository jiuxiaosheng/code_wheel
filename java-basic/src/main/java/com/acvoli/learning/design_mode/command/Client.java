package com.acvoli.learning.design_mode.command;

/**
 * 命令(Command)模式
 * 使用命令来参数化其他对象
 * 将命令放入队列中进行排队
 * 将命令的操作记录到日志中
 * 支持可撤销的操作
 */
class Client {
  public static void main(String[] args) {
    //
    Invoker invoker = new Invoker();
    Light light = new Light();
    Command lightOnCommand = new LightOnCommand(light);
    Command lightOffCommand = new LightOffCommand(light);

    invoker.setOnCommand(lightOffCommand, 0);
    invoker.setOffCommand(lightOffCommand, 0);

    invoker.onButtonWasPushed(0);
    invoker.offButtonWasPushed(0);
  }
}
