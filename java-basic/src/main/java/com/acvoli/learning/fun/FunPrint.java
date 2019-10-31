package com.acvoli.learning.fun;

public class FunPrint<T> {
  private static final String labels_row = "|";
  private static final String row_separator = "-";
  private static final String row_join = "+";

  public void print(T[] objects) {
    StringBuilder strToPrint = new StringBuilder();
    StringBuilder rowSeparator = new StringBuilder();

    for (T object : objects) {
      String str = object.toString();
      int length = str.length();
      strToPrint.append(labels_row);
      strToPrint.append(" ");
      strToPrint.append(str);
      strToPrint.append(" ");
      rowSeparator.append(row_join);
      rowSeparator.append(new String(new char[length + 2]).replace("\0", row_separator));
    }

    rowSeparator.append(row_join);
    strToPrint.append(labels_row);

    System.out.println(rowSeparator);
    System.out.println(strToPrint);
    System.out.println(rowSeparator);
  }
}
