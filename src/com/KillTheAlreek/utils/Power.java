package com.KillTheAlreek.utils;

public class Power
{
    public Power(byte power)
    {
        this.power = power;
    }

    public void sumOfPowers(Power power1, Power power2)
    {
        this.power = (byte) (power1.getPower()+power2.getPower());
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
