package com.KillTheAlreek.characters;

import com.KillTheAlreek.utils.Statistics;

public class Player
{
    public Player()
    {
        statistics = new Statistics();
    }

    Statistics statistics;

    public void info()
    {
        statistics.print();
    }
}
