package com.KillTheAlreek.story;

import com.KillTheAlreek.utils.GameLogic;
import com.KillTheAlreek.characters.*;

import java.util.Scanner;

abstract public class Story
{
    public static void introducePlayer(Player player)
    {
        String name;
        String place;
        boolean correctName;
        boolean correctPlace;

        GameLogic.printStringLBL("Przedstaw się!");
        GameLogic.printStringLBL("Jak się nazywasz?");
        name = scanner.nextLine();
        GameLogic.printStringLBL("Twoje imię to: " + name + " [T/N]?");
        correctName = GameLogic.getTrueOrFalse();
        while (!correctName)
        {
            GameLogic.printStringLBL("Podaj poprawne imię!");
            name = scanner.nextLine();
            GameLogic.printStringLBL("Twoje imię to: " + name + " [T/N]?");
            correctName = GameLogic.getTrueOrFalse();
        }

        GameLogic.printStringLBL("Skąd pochodzisz?");
        place = scanner.nextLine();
        GameLogic.printStringLBL("Twoje miejsce pochodzenia to: " + place + " [T/N]?");
        correctPlace = GameLogic.getTrueOrFalse();
        while (!correctPlace)
        {
            GameLogic.printStringLBL("Podaj poprawne miejsce pochodzenia!");
            place = scanner.nextLine();
            GameLogic.printStringLBL("Twoje miejsce pochodzenia to: " + place + " [T/N]?");
            correctPlace = GameLogic.getTrueOrFalse();
        }

        player.setName(name);
        player.setPlace(place);
    }

    public static void intro()
    {

    }

    static Scanner scanner = new Scanner(System.in);
}
