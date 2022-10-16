package org.acsn1.practicecore;

import org.acsn1.practicecore.managers.ArenaManager;
import org.acsn1.practicecore.objects.Arena;
import org.bukkit.plugin.java.JavaPlugin;


public final class PracticeCore extends JavaPlugin {

    public ArenaManager arenaManager;

    @Override
    public void onEnable() {
        arenaManager = new ArenaManager(this);
        arenaManager.loadArenas();


    }

    @Override
    public void onDisable() {

    }

    private void registerCommands(){

    }

    private void registerEvents(){

    }




}
