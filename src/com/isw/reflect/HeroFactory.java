package com.isw.reflect;

public class HeroFactory {

  public static ISkill getHero(String heroName) throws Exception {
    //    类是对象的抽象 元类对类的描述 meta class
    String heroNameWithPrefix = "com.isw.reflect.hero." + heroName;
    //    反射可以动态的生成实例
    Class<?> aClass = Class.forName(heroNameWithPrefix);
    Object o = aClass.newInstance();
    return (ISkill) o;
  }
}
