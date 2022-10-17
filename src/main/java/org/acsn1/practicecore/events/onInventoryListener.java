package org.acsn1.practicecore.events;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class onInventoryListener implements Listener {

    private PracticeCore core;
    public onInventoryListener(PracticeCore core){
        this.core = core;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(!(event.getWhoClicked() instanceof Player)) return;
        if(event.getCurrentItem() == null) return;

        Player p = (Player) event.getWhoClicked();
        Inventory inv = event.getClickedInventory();
        ItemStack item = event.getCurrentItem();



            
        if(inv.getTitle().equals(core.gameSelectGUI.getInv().getTitle())){
            if(item.getType().equals(Material.DIAMOND)){
                core.getQueueManager().addToQueue(p, core.getKitManager().getKit("NoDebuff"));
                p.closeInventory();
            }
        }
    }

}
