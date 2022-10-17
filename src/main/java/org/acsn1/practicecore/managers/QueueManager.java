package org.acsn1.practicecore.managers;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.objects.Arena;
import org.acsn1.practicecore.objects.Game;
import org.acsn1.practicecore.objects.GameQueue;
import org.acsn1.practicecore.objects.Kit;
import org.acsn1.practicecore.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class QueueManager {

    private static HashSet<GameQueue> gameQueues;
    private int i = 0;

    private PracticeCore core;
    public QueueManager(PracticeCore core){
        this.core = core;
        this.loadQueue();
    }

    private void loadQueue() {

        gameQueues = new HashSet<>();

        for(Kit kits:core.getKitManager().getKits()) {

            gameQueues.add(new GameQueue(new HashSet<Player>(), kits));

        }

        for (GameQueue gameQueue : getGameQueues()) {
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(core, () -> {
                if (gameQueue.getQueuedPlayers().size() >= 2) {
                    i++;

                    if (i % gameQueue.getQueuedPlayers().size() == 0) {
                        for (Player queuedPlayers : gameQueue.getQueuedPlayers()) {
                            ChatUtils.msg(queuedPlayers, "&7Searching for an available arena.");
                        }
                    }

                    Arena arena = core.getArenaManager().getRandomArena();

                    if (core.getArenaManager().isReady(arena)) {

                        Player first = (Player) gameQueue.getQueuedPlayers().toArray()[0];
                        Player second = (Player) gameQueue.getQueuedPlayers().toArray()[1];
                        Player[] gamePlayers = {first, second};

                        Game game = new Game(gamePlayers, arena, gameQueue.getKit(), System.currentTimeMillis(), 0l);
                        core.getGameManager().addGame(game);
                        gameQueue.getQueuedPlayers().remove(second);
                        gameQueue.getQueuedPlayers().remove(first);
                        i = 0;
                    }
                }

            }, 0, 60L);
        }
    }

    public void addToQueue(Player p, Kit kit){

        for(GameQueue gameQueue : getGameQueues()){
            if(gameQueue.getKit().equals(kit)){
                if(gameQueue.getQueuedPlayers().contains(p)) {
                    ChatUtils.msg(p, "&cYou are already in the queue for " + kit.getName());
                    return;
                } else{
                    gameQueue.getQueuedPlayers().add(p);
                    ChatUtils.msg(p, "&aYou have joined the queue for " + kit.getName());
                }
            }
        }

    }

    public Set<GameQueue> getGameQueues(){
        return gameQueues;
    }


}
