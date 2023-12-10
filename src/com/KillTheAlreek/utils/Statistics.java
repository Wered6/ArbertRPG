package com.KillTheAlreek.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;

public class Statistics
{
    public Statistics()
    {
        level = new Level();
        itemPower = new Power((byte) 0);
        finalPower = new Power((byte) 0);
        updateFromJson();
        finalPower.sumOfPowers(basePower, itemPower);
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

                if (level == this.level.getCurrentLevel())
                {

                    this.healthPoints = new HealthPoints((short) healthPoints);
                    this.basePower = new Power((byte) power);
                    this.mana = new Mana((short) mana);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void print()
    {
        System.out.println();
        System.out.println("Statystyki:");
        System.out.println("Level: " + level.getCurrentLevel());
        System.out.println("Health Points: " + healthPoints.getCurrent());
        System.out.println("Mana: " + mana.getCurrent());
        System.out.println("Power (base + item): " + finalPower.getPower() + "(" + basePower.getPower() + " + " + itemPower.getPower() + ")");
    }

    private Level level;

    private HealthPoints healthPoints;
    private Mana mana;

    private Power basePower;
    private Power itemPower;
    private Power finalPower;
}
