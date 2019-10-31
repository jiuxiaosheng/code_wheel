package com.acvoli.learning.design_mode.memento;

interface Calculator {

  // 创建备忘录
  PreviousCalculationToCareTaker backupLastCalculation();

  // 从备忘录中恢复信息
  void restorePreviousCalculation(PreviousCalculationToCareTaker memento);

  int getCalculationResult();

  void setFirstNumber(int firstNumber);

  void setSecondNumber(int secondNumber);
}
