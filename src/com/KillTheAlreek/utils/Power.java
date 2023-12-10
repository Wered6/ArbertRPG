package com.KillTheAlreek.utils;

public class Power
{
    public Power(byte power)
    {
        this.power = power;
    }

    public Power addPower(Power otherPower)
    {
        return new Power((byte)(this.power + otherPower.power));
    }

    public byte getPower()
    {
        return power;
    }

    public void setPower(byte power)
    {
        this.power = power;
    }

    private byte power;
}
