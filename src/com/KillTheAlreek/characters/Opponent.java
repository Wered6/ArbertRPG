package com.KillTheAlreek.characters;

import com.KillTheAlreek.utils.MonsterStatistics;

public class Opponent
{

    public Opponent(int id)
    {
        monsterStatistics = new MonsterStatistics(id);
    }

    MonsterStatistics monsterStatistics;

    public void info()
    {
        monsterStatistics.print();
    }


}
