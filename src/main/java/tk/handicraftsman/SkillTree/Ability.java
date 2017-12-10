/*
Copyright © 2017-2018 Nickolay Ilyushin <nickolay02@inbox.ru>
This work is free. You can redistribute it and/or modify it under the
terms of the Do What The Fuck You Want To Public License, Version 2,
as published by Sam Hocevar. See the LICENSE.txt file for more details.
*/

package tk.handicraftsman.SkillTree;

import java.util.ArrayList;

public class Ability {
  public String id;
  public ArrayList<Ability> childAbilities;
  public Integer level = 0;
  public Float exp = 0f;

  public Ability() {
    this.id = "";
    this.childAbilities = new ArrayList<>();
  }
}