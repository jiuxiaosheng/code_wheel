package com.acvoli.learning.design_mode.builder;

class Client {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    final int count = 26;
    for (int i = 0; i < count; i++) {
      sb.append((char) ('a' + i));
    }
    System.out.println(sb.toString());
  }
}
