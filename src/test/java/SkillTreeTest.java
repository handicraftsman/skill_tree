/*
Copyright © 2017-2018 Nickolay Ilyushin <nickolay02@inbox.ru>
This work is free. You can redistribute it and/or modify it under the
terms of the Do What The Fuck You Want To Public License, Version 2,
as published by Sam Hocevar. See the LICENSE.txt file for more details.
*/

import org.junit.Test;

import tk.handicraftsman.SkillTree.AbilityError;
import tk.handicraftsman.SkillTree.trees.FireTree;

public class SkillTreeTest {
  @Test public void lookupsWork() throws AbilityError {
    FireTree fireTree = new FireTree();
    fireTree.lookup("light-fire");
    fireTree.lookup("flamethrower");
    fireTree.lookup("fire-whip");
  }
  
  @Test public void levelsWork() throws AbilityError {
    FireTree fireTree = new FireTree();
    assert(fireTree.canUpgrade("light-fire"));
    fireTree.incExp("light-fire", 10f);
    assert(fireTree.canUpgrade("flamethrower") == false);
    fireTree.incExp("light-fire", 90f);
    assert(fireTree.canUpgrade("flamethrower"));
    assert(fireTree.canUpgrade("fire-whip") == false);
    fireTree.incExp("flamethrower", 100f);
    assert(fireTree.canUpgrade("fire-whip"));
  }
}
