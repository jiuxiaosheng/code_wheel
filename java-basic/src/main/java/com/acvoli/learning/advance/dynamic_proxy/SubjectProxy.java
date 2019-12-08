package com.acvoli.learning.advance.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理，代理类角色
 */
public class SubjectProxy {
  private Subject subject;

  /**
   * 初始化时绑定委托对象
   * @param subject 委托对象
   */
  public SubjectProxy(Subject subject) {
    this.subject = subject;
  }

  public Subject create() {

    // 取得委托对象的classLoader
    final ClassLoader classLoader = Subject.class.getClassLoader();
    // 获取委托对象的接口数组，代理类将实现这些接口
    final Class<?>[] interfaces = new Class[] {Subject.class};
    // 方法调用的handler，代理类的每个方法被调用时都会调用该handler的invoke方法
    final SubjectInvocationHandler handler = new SubjectInvocationHandler(subject);

    // 绑定该类实现的所有接口，取得代理对象实例，代理类实例的生成是通过反射实现的
    return (Subject) Proxy.newProxyInstance(classLoader, interfaces, handler);
  }

  public class SubjectInvocationHandler implements InvocationHandler {

    private final Subject subject;

    public SubjectInvocationHandler(Subject subject) {
      this.subject = subject;
    }

    /**
     * 代理对象方法调用时的实际调用方法
     * @param proxy 代理对象
     * @param method 调用的方法
     * @param args 调用方法的参数
     * @return 返回委托对象处理后的结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      // 在这里就可以实现AOP编程
      // 可在调用具体函数方法前后执行功能处理（功能增强）
      System.out.println("--before running--");
      // 该结果是委托对象自己方法执行后的结果
      Object result = method.invoke(subject, args);
      System.out.println("--after running--");
      return result;
    }
  }
}
