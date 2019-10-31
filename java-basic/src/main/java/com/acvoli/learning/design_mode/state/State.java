package com.acvoli.learning.design_mode.state;

interface State {
  /** 投入 25 分钱 */
  void insertQuarter();

  /** 退回 25 分钱 */
  void ejectQuarter();

  /** 转动曲柄 */
  void turnCrank();

  /** 发放糖果 */
  void dispense();
}
