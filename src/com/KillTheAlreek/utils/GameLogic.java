package com.KillTheAlreek.utils;

import java.util.Scanner;

abstract public class GameLogic
{
    // method to get user input from console
    public static int readInt(String prompt, int userChoices)
    {
        int input;

        do
        {
            System.out.println(prompt);
            try
            {
                input = Integer.parseInt(scanner.next());
            }
            catch (Exception e)
            {
                input = -1;
                printStringLBL("Wprowadź liczbę całkowitą (integer)!");
            }
        }
        while (input < 1 || input > userChoices);

        return input;
    }

    // method to simulate clearing out the console
    public static void clearConsole()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }

    // method to print seperator with length n
    public static void printSeperator(int n)
    {
        for (int i = 0; i < n; i++)
        {
            printStringLBL("-");
        }
        System.out.println();
    }

    // method to print heading
    public static void printHeading(String title)
    {
        printSeperator(30);
        printStringLBL(title);
        printSeperator(30);
    }

    // method to stop the game until user enters anything
    public static void anythingToContinue()
    {
        printStringLBL("\nWprowadź cokolwiek by kontynuuować...");
        scanner.next();
    }

    // method to print anything letter by letter with custom sleep time
    public static void printStringLBL(String str, long sleepTime)
    {
        for (int i = 0; i < str.length(); i++)
        {
            System.out.print(str.charAt(i));
            try
            {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    // method to print anything letter by letter
    public static void printStringLBL(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            System.out.print(str.charAt(i));
            try
            {
                Thread.sleep(35);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static boolean getTrueOrFalse()
    {
        while (true)
        {
            String input = scanner.nextLine();
            if ("T".equalsIgnoreCase(input))
            {
                return true;
            }
            else if ("N".equalsIgnoreCase(input))
            {
                return false;
            }
            else
            {
                printStringLBL("Wprowadź T/N");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
