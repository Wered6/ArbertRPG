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

    public MonsterStatistics getMonsterStatistics() {
        return monsterStatistics;
    }

    public int attack(Player player){
        //logika
        return 0;
    }

    MonsterStatistics monsterStatistics;

}
