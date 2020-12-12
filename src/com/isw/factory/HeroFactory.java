package com.isw.factory;

import com.isw.factory.hero.Camille;
import com.isw.factory.hero.Diana;
import com.isw.factory.hero.Irelia;

public class HeroFactory {

  public static ISkill getHero(String heroName) throws Exception {
    ISkill iSkill;
    switch (heroName) {
      case "Diana":
        iSkill = new Diana();
        break;
      case "Irelia":
        iSkill = new Irelia();
        break;
      case "Camille":
        iSkill = new Camille();
        break;
      default:
        throw new Exception();
    }
    return iSkill;
  }
}
