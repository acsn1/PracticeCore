package org.acsn1.practicecore.objects;

import org.bukkit.inventory.ItemStack;

public class Kit {

    private String name;
    private ItemStack[] items;
    private ItemStack[] armor;

    public Kit(String name, ItemStack[] items, ItemStack[] armor){
        this.name = name;
        this.items = items;
        this.armor = armor;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemStack[] getItems() {
        return items;
    }

    public void setItems(ItemStack[] items) {
        this.items = items;
    }

    public ItemStack[] getArmor() {
        return armor;
    }

    public void setArmor(ItemStack[] armor) {
        this.armor = armor;
    }
}
