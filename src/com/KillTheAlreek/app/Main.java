package com.KillTheAlreek.app;

import com.KillTheAlreek.characters.*;
import com.KillTheAlreek.utils.GameLogic;
import com.KillTheAlreek.story.*;

public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player();
        Story.introducePlayer(player);

        System.out.println(player.getFullName());
        player.info();
        player.levelUp();
        player.info();
        GameLogic.anythingToContinue();
    }
}