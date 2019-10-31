package com.acvoli.learning.design_mode.chain_of_responsibility;

class Request {
  private RequestType type;
  private String name;

  public Request(RequestType type, String name) {
    this.type = type;
    this.name = name;
  }

  public RequestType getType() {
    return type;
  }

  public String getName() {
    return name;
  }
}
