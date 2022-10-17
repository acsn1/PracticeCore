package org.acsn1.practicecore.managers;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.objects.Kit;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class KitManager {

    private PracticeCore core;
    public KitManager(PracticeCore core){
        this.core = core;
        this.loadKits();
    }

    private static Set<Kit> KITS = new HashSet<>();


    public void loadKits(){

        //hard coded-single kit
        Kit kit = new Kit("NoDebuff", new ItemStack[0], new ItemStack[0]);
        KITS.add(kit);

    }

    public Set<Kit> getKits(){
        return KITS;
    }

    public Kit getKit(String name){
        for(Kit kits : getKits()){
            if(kits.getName().equals(name)){
                return kits;
            } else{
                return null;
            }
        }

        return null;
    }




}
