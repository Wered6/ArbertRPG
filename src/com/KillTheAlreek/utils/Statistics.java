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
        basePower = new Power();
        itemPower = new Power();
        finalPower = basePower.addPower(itemPower);
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

                if (level == this.level.getCurrentLevel())
                {
                    this.basePower.setPower((byte) power);
                    this.healthPoints.setMax((short) healthPoints);
                    this.mana.setMax((short) mana);
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
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + healthPoints);
        System.out.println("Mana: " + mana);
        System.out.println("Power (base + item): " + finalPower + "(" + basePower + " + " + itemPower + ")");
    }

    private Level level;

    private HealthPoints healthPoints;

    private Mana mana;

    private Power basePower;
    private Power itemPower;
    private Power finalPower;
}
