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
        finalPower = basePower.addPower(itemPower);
        updateFromJson();
    }

    public void updateFromJson()
    {
        try
        {
            String currentDirectory = System.getProperty("user.dir");
            String relativePath = "src\\com\\KillTheAlreek\\utils\\levels.json";
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
                    this.baseHealthPoints.setMaxValue((short) healthPoints);
                    this.baseMana.setMaxValue((short) mana);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private Level level;

    private HealthPoints baseHealthPoints;

    private Mana baseMana;

    private Power basePower;
    private Power itemPower;
    private Power finalPower;
}
