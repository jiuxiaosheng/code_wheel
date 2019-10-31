package com.acvoli.learning.design_mode.memento;

/**
 * 在不违反封装的情况下获得对象的内部状态，从而在需要时可以将对象恢复到最初状态。
 */
class Client {
  public static void main(String[] args) {
    Calculator calculator = new CalculatorImp();

    // 最初计算值
    calculator.setFirstNumber(10);
    calculator.setSecondNumber(100);

    System.out.println(calculator.getCalculationResult());

    // 获取计算器当前状态备忘信息
    PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();

    // 重新输入需要计算的值
    calculator.setFirstNumber(17);
    calculator.setSecondNumber(-290);

    // 计算器计算了新值
    System.out.println(calculator.getCalculationResult());

    // 从备忘录中恢复值
    calculator.restorePreviousCalculation(memento);

    // 打印出上一次计算结果，即保存在备忘录中的值
    System.out.println(calculator.getCalculationResult());
  }
}
