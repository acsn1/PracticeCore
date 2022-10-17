package org.acsn1.practicecore.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GameSelectGUI {

    private final Inventory inv;

    public GameSelectGUI(){

        inv = Bukkit.createInventory(null, 9, "Select a Game");

        ItemStack ndb = new ItemStack(Material.DIAMOND);
        ItemMeta ndbmeta = ndb.getItemMeta();
        ndbmeta.setDisplayName("No Debuff");
        ndbmeta.addEnchant(Enchantment.DURABILITY, 1, true);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("Click to play.");
        lore.add("");
        ndbmeta.setLore(lore);
        ndb.setItemMeta(ndbmeta);

        inv.setItem(0, ndb);

    }

    public void openGUI(Player p){
        p.openInventory(inv);
    }

    public Inventory getInv() {
        return inv;
    }
}
