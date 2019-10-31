package com.acvoli.learning.design_mode.chain_of_responsibility;

/** 责任链模式（chain of responsibility） 大部分filter， exception handler都是用这种方式来处理 */
class Client {
  public static void main(String[] args) {

    /*
     * 配置handler1的后继处理器为空，相当于handler1处于责任链的最末端，
     * 如果一个请求到handler1这里还没法处理的时候，则不会对该请求进行任何处理
     */
    Handler handler1 = new ConcreteHandler1(null);
    // 配置handler2的后继处理器为handler1
    Handler handler2 = new ConcreteHandler2(handler1);

    // 此处request1虽然直接给到handler2进行处理，但因为不是handler2自身可以处理的类型，因此会给到后继handler，即handler1
    Request request1 = new Request(RequestType.TYPE1, "request1");
    handler2.handleRequest(request1);

    Request request2 = new Request(RequestType.TYPE2, "request2");
    handler2.handleRequest(request2);
  }
}
