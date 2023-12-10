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
        Opponent monster1 = new Opponent(1);
        monster1.info();
    }
}