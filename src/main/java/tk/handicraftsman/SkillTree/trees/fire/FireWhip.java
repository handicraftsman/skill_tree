/*
Copyright © 2017-2018 Nickolay Ilyushin <nickolay02@inbox.ru>
This work is free. You can redistribute it and/or modify it under the
terms of the Do What The Fuck You Want To Public License, Version 2,
as published by Sam Hocevar. See the LICENSE.txt file for more details.
*/

package tk.handicraftsman.SkillTree.trees.fire;

import java.util.ArrayList;

import tk.handicraftsman.SkillTree.Ability;

public class FireWhip extends Ability {
  public FireWhip() {
    this.id = "fire-whip";
    this.childAbilities = new ArrayList<>();
  }
}
