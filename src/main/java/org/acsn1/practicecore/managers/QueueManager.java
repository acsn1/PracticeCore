package org.acsn1.practicecore.managers;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class QueueManager {

    private static Set<Player> queue;

    private PracticeCore core;
    public QueueManager(PracticeCore core){
        this.core = core;
        queue=new HashSet<>();
        this.loadQueue();
    }

    private void loadQueue(){

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(core, () -> {

            if(queue.size() >= 2){
                Player first = (Player) queue.toArray()[0];
                Player second = (Player) queue.toArray()[1];
                //new Game with first/second GameManager


            }

        },0, 60L);
    }


}
