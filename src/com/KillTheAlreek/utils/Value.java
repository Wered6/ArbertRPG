package com.KillTheAlreek.utils;

abstract public class Value
{
    public Value(short maxValue)
    {
        this.maxValue = maxValue;

        currentValue = maxValue;
    }

    public void increaseCurrentValue(short amountOfValue)
    {
        if (currentValue + amountOfValue > maxValue)
        {
            currentValue = maxValue;
        } else
        {
            currentValue += amountOfValue;
        }
    }

    public void decreaseCurrentValue(short amountOfValue)
    {
        if (currentValue - amountOfValue < 0)
        {
            currentValue = 0;
        } else
        {
            currentValue -= amountOfValue;
        }
    }

    public short getCurrentValue()
    {
        return currentValue;
    }

    public short getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(short newMaxValue)
    {
        short differenceValue = (short) (newMaxValue - maxValue);

        currentValue += differenceValue;
        maxValue = newMaxValue;
    }

    private short currentValue;
    private short maxValue;
}
