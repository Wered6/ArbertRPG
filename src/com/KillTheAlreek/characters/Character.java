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
        currentLevel = new Level();
        fullName = name + " of " + city;
    }

    public void addExperience(int amountOfExperience)
    {
        currentLevel.addExperience(amountOfExperience);
    }

    public void PrintEverything()
    {
        System.out.println();
        System.out.println("Nazwa:\t\t\t|" + fullName);
        System.out.println("Level:\t\t\t|" + currentLevel.getCurrentLevel());
        System.out.println("Doświadczenie:\t|" + currentLevel.getCurrentExperience() + "/" + currentLevel.getNextLevelExperience());
        System.out.println("HP:\t\t\t\t|" + HP.getCurrentHP() + "/" + HP.getMaxHP());
        System.out.println("Moc:\t\t\t|" + power);
    }
    
    private HealthPoints HP;

    private byte power;

    private Level currentLevel;

    private String name;
    private String city;
    private String fullName;
}
