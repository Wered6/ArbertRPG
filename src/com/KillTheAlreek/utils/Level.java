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
        setNextLevelExperience();
    }

    public void addExperience(int amountOfExperience)
    {
        currentExperience += amountOfExperience;

        while (currentExperience >= nextLevelExperience)
        {
            levelUp();
            setNextLevelExperience();
        }
    }

    private void setNextLevelExperience()
    {
        try
        {
            String currentDirectory = System.getProperty("user.dir");
            String relativePath = "src\\com\\KillTheAlreek\\utils\\playerData.json";
            String jsonFilePath = currentDirectory + "\\" + relativePath;

            FileReader fileReader = new FileReader(jsonFilePath);
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            JSONObject jsonObject = new JSONObject(jsonTokener);
            JSONArray levelsArray = jsonObject.getJSONArray("statistics");

            for (int i = 0; i < levelsArray.length(); i++)
            {
                JSONObject levelData = levelsArray.getJSONObject(i);
                int level = levelData.getInt("level");
                int nextLevelExperience = levelData.getInt("nextLevelExperience");

                if (level == currentLevel)
                {
                    this.nextLevelExperience = nextLevelExperience;
                    break;
                }
            }
            fileReader.close();
        }
        catch (Exception e)
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
