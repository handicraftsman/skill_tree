/*
Copyright © 2017-2018 Nickolay Ilyushin <nickolay02@inbox.ru>
This work is free. You can redistribute it and/or modify it under the
terms of the Do What The Fuck You Want To Public License, Version 2,
as published by Sam Hocevar. See the LICENSE.txt file for more details.
*/

package tk.handicraftsman.SkillTree;

public class SkillTreeResolver {
  public Ability parent = null, child = null;
  
  public Boolean resolve(Ability ability, String abilityId) {
    if (ability.id.equals(abilityId)) {
      child = ability;
      System.out.println(String.format("Resolved: %s", ability.id));
      return true;
    }
    
    for (Ability ab : ability.childAbilities) {
      if (ab.id.equals(abilityId)) {
        System.out.println(String.format("Resolved: %s %s", ability.id, ab.id));
        parent = ability;
        child  = ab;
        return true;
      }
      
      if (this.resolve(ab, abilityId)) {
        return true;
      }
    }
    
    return false;
  }
}
