package com.KillTheAlreek.characters;

import com.KillTheAlreek.utils.*;

abstract public class Character
{
    public Character(String name, String city)
    {
        this.name = name;
        this.city = city;

        HP = new HealthPoints((short) 100);
        power = 0;
        level = 1;
        experience = 0;
        experienceToNextLevel = 200;
        fullName = name + " of " + city;
    }

    public void PrintEverything()
    {
        System.out.println("Nazwa:\t\t\t|" + fullName);
        System.out.println("Level:\t\t\t|" + level);
        System.out.println("Doświadczenie:\t|" + experience + "/" + experienceToNextLevel);
        System.out.println("HP:\t\t\t\t|" + HP.getCurrentHP() + "/" + HP.getMaxHP());
        System.out.println("Moc:\t\t\t|" + power);
    }
    
    private HealthPoints HP;

    private byte power;

    private byte level;
    private int experience;
    private int experienceToNextLevel;

    private String name;
    private String city;
    private String fullName;
}
