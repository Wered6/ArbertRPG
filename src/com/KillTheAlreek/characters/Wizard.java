package com.KillTheAlreek.characters;

public class Wizard extends Character
{
    public Wizard(String name, String city)
    {
        super(name, city);

        mana = 100;
        maxMana = 100;
    }

    @Override
    public void PrintEverything()
    {
        super.PrintEverything();
        System.out.println("mana:\t\t\t|" + mana + "/" + maxMana);
    }

    private short mana;
    private short maxMana;
}
