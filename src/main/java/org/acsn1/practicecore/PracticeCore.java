package org.acsn1.practicecore;

import org.acsn1.practicecore.gui.GameSelectGUI;
import org.acsn1.practicecore.managers.*;
import org.bukkit.plugin.java.JavaPlugin;


public final class PracticeCore extends JavaPlugin {

    //GUIS
    public GameSelectGUI gameSelectGUI;


    //Managers
    private ArenaManager arenaManager;
    private KitManager kitManager;
    private EventManager eventManager;
    private CommandManager commandManager;
    private ProfileManager profileManager;
    private QueueManager queueManager;
    private GameManager gameManager;

    @Override
    public void onEnable() {

        //managers
        arenaManager = new ArenaManager(this);
        kitManager = new KitManager(this);
        eventManager = new EventManager(this);
        commandManager = new CommandManager(this);
        profileManager = new ProfileManager(this);
        queueManager = new QueueManager(this);
        gameManager = new GameManager(this);

        //guis
        gameSelectGUI = new GameSelectGUI();

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

    public QueueManager getQueueManager() {
        return queueManager;
    }

    public GameManager getGameManager() {
        return gameManager;
    }
}
