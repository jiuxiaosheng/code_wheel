package com.acvoli.learning.design_mode.chain_of_responsibility;

class ConcreteHandler1 extends Handler {

  public ConcreteHandler1(Handler successor) {
    super(successor);
  }

  @Override
  protected void handleRequest(Request request) {
    if (request.getType() == RequestType.TYPE1) {
      // 如果判断是自己的职责进行处理，则在此处进行逻辑处理，并返回表示完成该请求，无需其他handler再做处理
      System.out.println(request.getName() + "is handle by ConcreteHandler1");
      // 如果自己处理完了，则直接返回
      return;
    }
    // 如果不应该自己处理，并且由后继的handler，则让后继handler再做判断处理
    if (successor != null) {
      successor.handleRequest(request);
    }
  }
}
