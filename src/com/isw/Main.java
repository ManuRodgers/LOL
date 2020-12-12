package com.isw;

import com.isw.reflect.HeroFactory;
import com.isw.reflect.ISkill;

import java.util.Scanner;

public class Main {

  //  public static void main(String[] args) {
  //    String heroName = Main.getHeroName();
  //    switch (heroName) {
  //      case "Diana":
  //        Diana diana = new Diana();
  //        diana.r();
  //        break;
  //      case "Irelia":
  //        Irelia irelia = new Irelia();
  //        irelia.r();
  //        break;
  //      case "Camille":
  //        Camille camille = new Camille();
  //        camille.r();
  //        break;
  //    }
  //  }

  //  public static void main(String[] args) throws Exception {
  //    String heroName = Main.getHeroName();
  //    ISkill iSkill;
  //    switch (heroName) {
  //      case "Diana":
  //        iSkill = new Diana();
  //        break;
  //      case "Irelia":
  //        iSkill = new Irelia();
  //        break;
  //      case "Camille":
  //        iSkill = new Camille();
  //        break;
  //      default:
  //        throw new Exception();
  //    }
  //    iSkill.r();
  //  }

  public static void main(String[] args) throws Exception {
    String heroName = Main.getHeroName();
    //    这里我们使用了静态方法的的特性，所以排除了new 但是这个地方的稳定是相对的
    //    简单工厂
    //    ISkill 是对英雄具体类的抽象
    ISkill iSkill = HeroFactory.getHero(heroName);
    iSkill.r();
    //    通过配置文件得到heroName, 改动配置文件是允许的, 没有违反OCP原则
    //    抽象工厂， 那么我们也可以对HeroFactory抽象出IHeroFactory
    //    spring ioc
    //    ApplicationContext and abstract factory is responsible for creating instances
  }

  private static String getHeroName() {
    System.out.println("Enter a hero's name");
    try (Scanner scanner = new Scanner(System.in)) {
      return scanner.nextLine();
    }
  }
}

// interface
// factory design model
// IOC inventory of controls
// DI dependencies injection
// OCP open closed principle
// maintainable code
//  重点理论
//  1.单纯的interface可以统一方法的调用，但是不能统一对象的实例化
//  2.面向对象主要就是干两件事情，第一件事就是实例化对象，第二件事情就是调用实例的方法
//  3.只有一段代码中没有出现new， 才能保持代码的相对稳定，才能逐步实现OCP 开闭原则 最终实现写出可维护性的代码
//  4. 上面的这句话只是表象，实质是一段代码如果要保持稳定， 就不应该负责实例化对象
//  5.在面向对象编程里面，对象的实例化是不可能消除的
//  6.把对象实例化的过程，转移到其他的代码片段里
//  7. 代码中总会存在不稳定，隔离这些不稳定的代码，将这些不稳定的代码进行集中管理，保证其他代码是稳定的
//  8. 程序的变化才是导致代码不稳定的根本原因
//  9. 工厂模式加上反射基本可以实现OCP原则， 但是spring 比这个更高级
// 10. 配置文件是可以改动的, 它不是你系统的一部分, 所以它没有违反OCP原则。
// 11。任何一个应用或者系统变化是不能避免的， 在程序的世界里主要有两大变化，第一是用户输入的变化， 另一个是应用需求的变动
// 12. IOC 容器本质上是在装配各种类， 各个类之间有相互依赖的关系。 composition
// 13. 面向抽象编程，各个实体类不关心他所依赖的某个属性具体注入了哪个值，只依赖接口， 具体注入哪个值由IOC容器决定, 从而实现了各个实体类的独立性
// 14. IOC 控制反转只指以前是程序员对对于一个系统的变化有控制权，现在是用户或者产品经理对于系统的变化有控制权。 就好像积木生产厂家， 由用户来决定怎么用生产出来的积木产出什么样的产品，积木就好像一个个Java类。
