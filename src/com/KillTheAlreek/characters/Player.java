package com.KillTheAlreek.characters;

import com.KillTheAlreek.utils.MonsterStatistics;
import com.KillTheAlreek.utils.Statistics;


public class Player
{
    public Player()
    {
        statistics = new Statistics();
    }

    public void chooseAttack()
    {
        System.out.println("1.Atak podstawowy");
        System.out.println("2.Atak specjalny " + statistics.getSpecialAttackName());
        System.out.println("3.Defensywa podstawowa");
        System.out.println("4.Defensywa magiczna");
    }

    public void info()
    {
        statistics.printInfo();
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


    public int attack(Monster monster){
        //logika
        return 0;
    }

    public Statistics getStatistics() {
        return statistics;
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
    public void levelUp()
    {
        statistics.levelUp();
    }


    private String name = "Noname";
    private String place = "Nowhere";
    private Statistics statistics;
}
