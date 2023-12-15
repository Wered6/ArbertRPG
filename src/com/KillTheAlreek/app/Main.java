package com.KillTheAlreek.app;

import com.KillTheAlreek.characters.*;
import com.KillTheAlreek.utils.GameLogic;

public class Main
{
    public static void main(String[] args)
    {
        Player player1 = new Player();
        System.out.println(player1.getFullName());
        player1.info();
        Monster monster1 = new Monster(1);
        monster1.info();
        Monster monster2 = new Monster(2);
        monster2.info();
        Monster monster3 = new Monster(3);
        monster3.info();
        Monster monster4 = new Monster(4);
        monster4.info();
        Monster monster5 = new Monster(5);
        monster5.info();
        GameLogic.anythingToContinue();
    }
}