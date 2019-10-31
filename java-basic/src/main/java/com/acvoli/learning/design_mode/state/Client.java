package com.acvoli.learning.design_mode.state;

/**
 * 允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它所属的类。 适用情况：某个对象有多种状态，不同状态下同一个操作会有不同的行为表现，状态可以发生转移，通过状态的转移导致行为的改变
 */
class Client {
  public static void main(String[] args) {
    GumballMachine gumballMachine = new GumballMachine(5);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();

    gumballMachine.insertQuarter();
    gumballMachine.ejectQuarter();
    gumballMachine.turnCrank();

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.ejectQuarter();

    gumballMachine.insertQuarter();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
  }
}
