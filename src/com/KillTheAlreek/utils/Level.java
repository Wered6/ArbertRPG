package com.KillTheAlreek.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;

public class Level
{
    public Level()
    {
        currentLevel = 1;
        currentExperience = 0;
        increaseNextLevelExperience();
    }

    public void addExperience(int amountOfExperience)
    {
        currentExperience += amountOfExperience;

        while (currentExperience >= nextLevelExperience)
        {
            levelUp();
            increaseNextLevelExperience();
        }
    }

    private void increaseNextLevelExperience()
    {
        try
        {
            String currentDirectory = System.getProperty("user.dir");
            String relativePath = "src\\com\\KillTheAlreek\\utils\\levels.json";
            String jsonFilePath = currentDirectory + "\\" + relativePath;
            FileReader fileReader = new FileReader(jsonFilePath);
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            JSONObject jsonObject = new JSONObject(jsonTokener);
            JSONArray levelsArray = jsonObject.getJSONArray("levels");

            for (int i = 0; i < levelsArray.length(); i++)
            {
                JSONObject levelData = levelsArray.getJSONObject(i);
                int level = levelData.getInt("level");
                int experienceRequired = levelData.getInt("experienceRequired");

                if (level == currentLevel)
                {
                    nextLevelExperience = experienceRequired;
                    break;
                }
            }
            fileReader.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void levelUp()
    {
        currentLevel++;
    }

    public byte getCurrentLevel()
    {
        return currentLevel;
    }

    public int getCurrentExperience()
    {
        return currentExperience;
    }

    public int getNextLevelExperience()
    {
        return nextLevelExperience;
    }

    private byte currentLevel;
    private int currentExperience;
    private int nextLevelExperience;
}
