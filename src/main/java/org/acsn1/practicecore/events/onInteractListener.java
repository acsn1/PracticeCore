package org.acsn1.practicecore.events;

import org.acsn1.practicecore.PracticeCore;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class onInteractListener implements Listener {

    private PracticeCore core;
    public onInteractListener(PracticeCore core){
        this.core = core;
    }

    @EventHandler
    public void interact(PlayerInteractEvent event){
        Player p = event.getPlayer();
        ItemStack item = event.getItem();

        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(item.getType().equals(Material.STONE_SWORD)){
                core.gameSelectGUI.openGUI(p);
                p.playSound(p.getLocation(),Sound.ANVIL_LAND, 3, 1);
            }
        }

    }

}
