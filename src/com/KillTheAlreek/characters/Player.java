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

    void showFullName()
    {
        System.out.println(name + "of" + place);
    }

    public String getFullName()
    {
        return name + " of " + place;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getName()
    {
        return name;
    }

    public String getPlace()
    {
        return place;
    }

    private String name = "Noname";
    String place = "Nowhere";
}
