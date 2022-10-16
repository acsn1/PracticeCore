package org.acsn1.practicecore.managers;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.profile.Profile;
import org.acsn1.practicecore.utils.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ProfileManager {

    private Set<Profile> PROFILES = new HashSet<>();
    private File file;
    private YamlConfiguration config;

    private PracticeCore core;

    public ProfileManager(PracticeCore core){
        this.core = core;
    }

    public void loadProfiles(){
        file = new File(core.getDataFolder() + "/data");

        if(!file.exists()) file.mkdirs();

        config = YamlConfiguration.loadConfiguration(file);

        if(file.isDirectory() && file.length() < 0) return;
        Profile p;

        for(File profiles:file.listFiles()){
            p = (Profile) ObjectUtils.deserializeObject(profiles.getName().replaceFirst(".yml", ""));
            PROFILES.add(p);
        }
        Bukkit.getLogger().fine("Successfully loaded all profiles.");

    }

    public void createProfile(Profile profile){

        if(PROFILES.contains(profile)) return;

        PROFILES.add(profile);

        ObjectUtils.serializeObject(profile, profile.getUuid().toString());

    }

    public Profile getProfile(UUID uuid){
        for(Profile profiles:PROFILES){
            if(profiles.getUuid() == uuid){
                return profiles;
            } else{
                return null;
            }
        }

        return null;
    }

    public Profile getProfile(String name){
        for(Profile profiles:PROFILES){
            if(profiles.getName() == name){
                return profiles;
            } else{
                return null;
            }
        }
        return null;
    }

    public void wipeProfiles(){

        PROFILES.clear();

        file = new File(core.getDataFolder() + "/data");

        if(file.exists()) file.delete(); file.mkdirs();
        file.mkdirs();

        Bukkit.getLogger().fine("Successfully wiped all the profiles.");
    }

}
