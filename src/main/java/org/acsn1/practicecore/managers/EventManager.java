package org.acsn1.practicecore.managers;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.events.onJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    private PracticeCore core;
    public EventManager(PracticeCore core){
        this.core = core;

        this.registerEvents();

    }

    private void registerEvents(){
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new onJoinListener(core), core);
    }




}
