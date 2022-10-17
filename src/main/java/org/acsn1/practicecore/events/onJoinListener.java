package org.acsn1.practicecore.events;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.objects.Stats;
import org.acsn1.practicecore.profile.Profile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class onJoinListener implements Listener {

    private PracticeCore core;
    public onJoinListener(PracticeCore core){
        this.core = core;
    }

    @EventHandler
    public void onJoin(PlayerLoginEvent event){
        Profile profile = new Profile(event.getPlayer().getName(), event.getPlayer().getUniqueId(), new Stats());
        core.getProfileManager().retrieveProfile(profile);
        System.out.println(core.getArenaManager().getRandomArena());

    }

}
