package com.KillTheAlreek.items;

import com.KillTheAlreek.utils.Power;

public class Item
{
    public Item(Power itemPower)
    {
        this.itemPower = itemPower;
    }

    public Power getItemPower()
    {
        return itemPower;
    }

    public void setItemPower(Power itemPower)
    {
        this.itemPower = itemPower;
    }

    private Power itemPower;
}
