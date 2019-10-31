package com.acvoli.learning.design_mode.interpreter;

import java.util.StringTokenizer;

class TerminalExpression extends Expression {

  private String literal = null;

  public TerminalExpression(String str) {
    literal = str;
  }

  @Override
  public boolean interpret(String str) {
    StringTokenizer st = new StringTokenizer(str);
    while (st.hasMoreTokens()) {
      String test = st.nextToken();
      if (test.equals(literal)) {
        return true;
      }
    }
    return false;
  }
}
