package com.KillTheAlreek.utils;

public class HealthPoints
{
    public HealthPoints(short maxHP)
    {
        this.maxHP = maxHP;

        currentHP = maxHP;
    }

    public void addHP(short amountOfHP)
    {
        if (currentHP + amountOfHP > maxHP)
        {
            currentHP = maxHP;
        }
        else
        {
            currentHP += amountOfHP;
        }
    }

    public void subHP(short amountOfHP)
    {
        if (currentHP - amountOfHP < 0)
        {
            currentHP = 0;
        }
        else
        {
            currentHP -= amountOfHP;
        }
    }

    public short getCurrentHP()
    {
        return currentHP;
    }

    public short getMaxHP()
    {
        return maxHP;
    }

    public void setMaxHP(short maxHP)
    {
        this.maxHP = maxHP;

        currentHP = maxHP;
    }

    private short currentHP;
    private short maxHP;
}
