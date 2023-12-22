package com.KillTheAlreek.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;

public class Statistics
{
    public Statistics()
    {
        level = 1;
        updateFromJson();
    }

    public void updateFromJson()
    {
        try
        {
            String currentDirectory = System.getProperty("user.dir");
            String relativePath = "src\\com\\KillTheAlreek\\utils\\playerData.json";
            String jsonFilePath = currentDirectory + "\\" + relativePath;

            FileReader fileReader = new FileReader(jsonFilePath);
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            JSONObject jsonObject = new JSONObject(jsonTokener);
            JSONArray statisticsArray = jsonObject.getJSONArray("statistics");

            for (int i = 0; i < statisticsArray.length(); i++)
            {
                JSONObject statisticsData = statisticsArray.getJSONObject(i);
                int level = statisticsData.getInt("level");
                int power = statisticsData.getInt("power");
                int healthPoints = statisticsData.getInt("healthPoints");
                int mana = statisticsData.getInt("mana");
                String itemName = statisticsData.getString("itemName");
                String itemDescription = statisticsData.getString("itemDescription");
                String specialAttackDescription = statisticsData.getString("specialAttackDescription");
                String specialAttackName = statisticsData.getString("specialAttackName");
                int specialAttackDamage = statisticsData.getInt("specialAttackDamage");

                if (this.level == level)
                {
                    this.power = power;
                    this.healthPoints = new HealthPoints((short) healthPoints);
                    this.mana = new Mana((short) mana);
                    this.itemName = itemName;
                    this.itemDescription = itemDescription;
                    this.specialAttackDescription = specialAttackDescription;
                    this.specialAttackDamage = specialAttackDamage;
                    this.specialAttackName = specialAttackName;

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void printInfo()
    {
        GameLogic.printStringLBL("");
        GameLogic.printStringLBL("Statystyki:");
        GameLogic.printStringLBL("Level: " + level);
        GameLogic.printStringLBL("Power: " + power);
        GameLogic.printStringLBL("Health Points: " + healthPoints.getCurrent() + "/" + healthPoints.getMax());
        GameLogic.printStringLBL("Mana: " + mana.getCurrent() + "/" + mana.getMax());
        GameLogic.printStringLBL("Item Name: " + itemName);
        GameLogic.printStringLBL("Item Description: " + itemDescription);
        GameLogic.printStringLBL("Special Attack: " + specialAttackDescription);
        GameLogic.printStringLBL("Special Attack Power: " + specialAttackDamage);
    }
    public void levelUp()
    {
        level++;
        updateFromJson();
    }

    public int getPower()
    {
        return power;
    }
    public HealthPoints getHealthPoints()
    {
        return healthPoints;
    }



    private int level;
    private HealthPoints healthPoints;
    private Mana mana;
    private int power;
    private String itemName;
    private String itemDescription;
    private String specialAttackDescription;
    private String specialAttackName;
    private int specialAttackDamage;
}
