package com.acvoli.learning.advance.dynamic_proxy;

public class Test {
  public static void main(String[] args) {

    /*
     * 核心概念：
     * 1：委托对象
     * 2：代理类
     * 3：InvocationHandler
     * 4：Proxy.newProxyInstance
     */
    Subject subject = new ConcreteSubject();
    SubjectProxy proxy = new SubjectProxy(subject);
    Subject proxyObj = proxy.create();
    proxyObj.run();
  }
}
