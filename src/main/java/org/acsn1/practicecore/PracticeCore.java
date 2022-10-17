package org.acsn1.practicecore;

import org.acsn1.practicecore.managers.*;
import org.bukkit.plugin.java.JavaPlugin;


public final class PracticeCore extends JavaPlugin {

    private ArenaManager arenaManager;
    private KitManager kitManager;
    private EventManager eventManager;
    private CommandManager commandManager;
    private ProfileManager profileManager;
    private QueueManager queueManager;
    private GameManager gameManager;

    @Override
    public void onEnable() {

        arenaManager = new ArenaManager(this);
        kitManager = new KitManager();
        eventManager = new EventManager(this);
        commandManager = new CommandManager(this);
        profileManager = new ProfileManager(this);
        queueManager = new QueueManager(this);
        gameManager = new GameManager(this);


    }

    @Override
    public void onDisable() {

    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    public KitManager getKitManager() {
        return kitManager;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public ProfileManager getProfileManager() {
        return profileManager;
    }
}
