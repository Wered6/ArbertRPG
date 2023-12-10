package com.KillTheAlreek.utils;

public class Power
{
    public Power()
    {
        this.power = 0;
    }

    public Power addPower(Power otherPower)
    {
        Power power1 = new Power();
        power1.setPower((byte) (power1.getPower() + otherPower.getPower()));

        return power1;
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
