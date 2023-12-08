package com.KillTheAlreek.characters;

public class Warrior extends Character
{
    public Warrior(String name, String city)
    {
        super(name, city);

        energy = 200;
        maxEnergy = 200;
    }

    @Override
    public void PrintEverything()
    {
        super.PrintEverything();
        System.out.println("Energia:\t\t|" + energy + "/" + maxEnergy);
    }

    private short energy;
    private short maxEnergy;
}
