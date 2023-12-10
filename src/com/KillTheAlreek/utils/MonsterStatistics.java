package com.KillTheAlreek.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;

public class MonsterStatistics
{
    public MonsterStatistics(int id)
    {
        this.id = id;
        updateFromJson();
    }

    public void updateFromJson()
    {
        try
        {
            String currentDirectory = System.getProperty("user.dir");
            String relativePath = "src\\com\\KillTheAlreek\\utils\\monstersData.json";
            String jsonFilePath = currentDirectory + "\\" + relativePath;

            FileReader fileReader = new FileReader(jsonFilePath);
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            JSONObject jsonObject = new JSONObject(jsonTokener);
            JSONArray monstersArray = jsonObject.getJSONArray("monsters");

            for (int i = 0; i < monstersArray.length(); i++)
            {
                JSONObject monstersData = monstersArray.getJSONObject(i);
                int id = monstersData.getInt("id");
                String name = monstersData.getString("name");
                int power = monstersData.getInt("power");
                int healthPoints = monstersData.getInt("healthPoints");

                if (id == this.id)
                {
                    this.name = name;
                    this.healthPoints = new HealthPoints((short) healthPoints);
                    this.basePower = new Power((byte) power);
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
        System.out.println("Statystyki potwora:");
        System.out.println("Nazwa potwora: " + name);
        System.out.println("Health Points: " + healthPoints.getCurrent() + "/" + healthPoints.getMax());
        System.out.println("Power: " + basePower.getPower());
    }


    private int id;
    private String name;
    private HealthPoints healthPoints;
    private Power basePower;
}