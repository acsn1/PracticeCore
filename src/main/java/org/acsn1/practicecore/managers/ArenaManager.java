package org.acsn1.practicecore.managers;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.objects.Arena;
import org.acsn1.practicecore.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class ArenaManager {

    /*
    We could have also used the serializable method of J2EE for storing/retrieving arena objects.
     */
    private PracticeCore core;
    public ArenaManager(PracticeCore core){
        this.core = core;
        this.loadArenas();
    }

    private static Set<Arena> ARENAS = new HashSet<>();
    private File file;
    private YamlConfiguration config;


    public void loadArenas(){
        file = new File(core.getDataFolder() + "/arenas");
        if(!(file.exists())) file.mkdirs();

        if(file.isDirectory()){
        for(File arenas : file.listFiles()) {
            if (arenas.exists()) {
                config = YamlConfiguration.loadConfiguration(arenas);

                String name = config.getString("arena.name");
                Location location = (Location) config.get("arena.location");
                Location first = (Location) config.get("arena.first");
                Location second = (Location) config.get("arena.second");
                boolean isBuildable = config.getBoolean("arena.isBuildable");


                ARENAS.add(new Arena(name, location, first, second, isBuildable, false));
                }
            }
        }
        //throw msg
        ChatUtils.log("Loaded all arenas successfully.");

    }

    public void createArena(Arena arena){
        if(ARENAS.contains(arena)) ChatUtils.log("&cArena " + arena.getName() + " exists.");

        ARENAS.add(arena);
        saveArena(arena);

    }

    public void saveArena(Arena arena){

        file = new File(core.getDataFolder() + "/arenas", arena.getName() + ".yml");
        config = YamlConfiguration.loadConfiguration(file);

        config.set("arena.name", arena.getName());
        config.set("arena.location", arena.getLocation());
        config.set("arena.first", arena.getFirst());
        config.set("arena.second", arena.getSecond());
        config.set("arena.isBuildable", arena.isBuildable());

        try{
            config.save(file);
        }catch(Exception ex){
            ChatUtils.log("Could not save arena " + arena.getName() + ".");
            ex.printStackTrace();
        }

    }

    public boolean isOccupied(Arena arena){
        return arena.isInUse();
    }

    public void deleteArena(Arena arena){
        if(ARENAS.contains(arena)) ChatUtils.log("Arena " + arena.getName() + " does not exist.");

        ARENAS.remove(arena);

        file = new File(core.getDataFolder() + "/arenas", arena.getName() + ".yml");
        if(file.exists()) file.delete();
        Bukkit.getLogger().fine("Arena " + arena.getName() + " was deleted.");
    }


    public Arena getRandomArena(){

        int random = ThreadLocalRandom.current().nextInt(ARENAS.size());

        return (Arena) ARENAS.toArray()[random];

    }


}
