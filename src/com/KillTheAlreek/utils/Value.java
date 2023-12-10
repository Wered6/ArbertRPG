package com.KillTheAlreek.utils;

abstract public class Value
{
    public Value(short maxValue)
    {
        this.maxValue = maxValue;

        currentValue = maxValue;
    }

    public void increaseCurrent(short amountOfValue)
    {
        if (currentValue + amountOfValue > maxValue)
        {
            currentValue = maxValue;
        } else
        {
            currentValue += amountOfValue;
        }
    }

    public void decreaseCurrent(short amountOfValue)
    {
        if (currentValue - amountOfValue < 0)
        {
            currentValue = 0;
        } else
        {
            currentValue -= amountOfValue;
        }
    }

    public short getCurrent()
    {
        return currentValue;
    }

    public short getMax()
    {
        return maxValue;
    }

    public void setMax(short newMaxValue)
    {
        short differenceValue = (short) (newMaxValue - maxValue);

        currentValue += differenceValue;
        maxValue = newMaxValue;
    }

    private short currentValue;
    private short maxValue;
}
