/*
Copyright © 2017-2018 Nickolay Ilyushin <nickolay02@inbox.ru>
This work is free. You can redistribute it and/or modify it under the
terms of the Do What The Fuck You Want To Public License, Version 2,
as published by Sam Hocevar. See the LICENSE.txt file for more details.
*/

package tk.handicraftsman.SkillTree;

public class SkillTree {
  public Ability rootAbility;

  public SkillTree() {}
  
  public AbilityPair lookup(String abilityId) throws AbilityError {
    if (this.rootAbility == null) { throw new AbilityError("Root ability is null!"); }
    
    SkillTreeResolver resolver = new SkillTreeResolver();
    if (!resolver.resolve(this.rootAbility, abilityId)) {
      throw new AbilityError(String.format("Cannot find ability %s!", abilityId));
    }
    
    return new AbilityPair(resolver.parent, resolver.child);
  }
  
  public Boolean canUpgrade(String abilityId) throws AbilityError {
    AbilityPair pair = this.lookup(abilityId);
    
    if (pair.parent == null && pair.child.level < 5) {
      return true;
    }
    
    if (pair.parent != null && pair.child.level < pair.parent.level && pair.child.level < 5) {
      return true;
    }
    
    return false;
  }
  
  public void upgrade(String abilityId) throws AbilityError {
    if (!this.canUpgrade(abilityId)) {
      throw new AbilityError(String.format("Cannot upgrade ability %s!", abilityId));
    }
    
    AbilityPair pair = this.lookup(abilityId);
    pair.child.level += 1;
  }
  
  public void incExp(String abilityId, Float inc) {
    try {
      AbilityPair pair = this.lookup(abilityId);
      if (!this.canUpgrade(abilityId)) { pair.child.exp = 0f; return; }
      pair.child.exp += inc;
      if (pair.child.exp >= 100f) { this.upgrade(abilityId); pair.child.exp = 0f; }
    } catch (AbilityError e) {}
  }
}