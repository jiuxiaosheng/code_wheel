package com.acvoli.learning.design_mode.singleton;

/** 使用枚举实现的方式 该实现可以防止反射攻击 该实现在多次序列化和序列化之后，不会得到多个实例 */
public enum SingletonEnum {
  INSTANCE;

  private String objName;

  public String getObjName() {
    return objName;
  }

  public void setObjName(String objName) {
    this.objName = objName;
  }

  public static void main(String[] args) {
    SingletonEnum firstSingleton = SingletonEnum.INSTANCE;
    firstSingleton.setObjName("firstName");
    System.out.println(firstSingleton.getObjName());

    SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
    secondSingleton.setObjName("secondName");

    System.out.println(firstSingleton.getObjName());
    System.out.println(secondSingleton.getObjName());

    // 反射获取实例测试
    try {
      SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
      for (SingletonEnum enumConstant : enumConstants) {
        System.out.println(enumConstant.getObjName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
