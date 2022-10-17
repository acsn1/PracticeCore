package org.acsn1.practicecore.managers;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.profile.Profile;
import org.acsn1.practicecore.utils.ChatUtils;
import org.acsn1.practicecore.utils.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ProfileManager {

    public static Set<Profile> PROFILES = new HashSet<>();
    private File file;
    private YamlConfiguration config;

    private PracticeCore core;

    public ProfileManager(PracticeCore core){
        this.core = core;
        this.loadProfiles();
    }

    public void loadProfiles(){
        file = new File(core.getDataFolder() + "/data");

        if(!file.exists()) file.mkdirs();

        config = YamlConfiguration.loadConfiguration(file);

        Profile p;

        for(File profiles:file.listFiles()){
            p = (Profile) ObjectUtils.deserializeObject(profiles.getName().replaceFirst(".profile", ""));
            PROFILES.add(p);
        }

        ChatUtils.log("Loaded all profiles successfully.");


    }

    public void retrieveProfile(Profile profile){

        if(profileExists(profile.getUuid())) return;
            PROFILES.add(profile);
            ObjectUtils.serializeObject(profile, profile.getUuid().toString());
        }

    public boolean profileExists(UUID uuid){
        for(Profile profiles:PROFILES){
            if(profiles.getUuid().equals(uuid)){
                return true;
            } else{
                return false;
            }
        }

        return false;

    }

    public Profile getProfile(UUID uuid){
        for(Profile profiles:PROFILES){
            if(profiles.getUuid().equals(uuid)){
                return profiles;
            } else{
                return null;
            }
        }
        return null;
    }

    public Profile getProfile(String name){
        for(Profile profiles:PROFILES){
            if(profiles.getName().equals(name)){
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

        ChatUtils.log("Wiped all profiles data successfully.");
    }

}
