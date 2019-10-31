package com.acvoli.learning.design_mode.chain_of_responsibility;

abstract class Handler {
  protected Handler successor;

  Handler(Handler successor) {
    this.successor = successor;
  }

  protected abstract void handleRequest(Request request);
}
