package com.KillTheAlreek.characters;

import com.KillTheAlreek.utils.MonsterStatistics;

public class Monster
{
    public Monster(int id)
    {
        monsterStatistics = new MonsterStatistics(id);
    }

    public void info()
    {
        monsterStatistics.printInfo();
    }

    MonsterStatistics monsterStatistics;
}
