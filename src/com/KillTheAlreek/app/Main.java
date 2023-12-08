package com.KillTheAlreek.app;

import com.KillTheAlreek.characters.*;

public class Main
{
    public static void main(String[] args)
    {
        Warrior warrior1 = new Warrior("Arbert", "Morgana");
        warrior1.PrintEverything();

        Wizard wizard1 = new Wizard("Ezreal", "Noxus");
        wizard1.PrintEverything();
    }
}