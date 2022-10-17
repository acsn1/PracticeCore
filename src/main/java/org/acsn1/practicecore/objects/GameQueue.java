package org.acsn1.practicecore.objects;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GameQueue {

    private HashSet<Player> queuedPlayers;
    private Kit kit;

    public GameQueue(HashSet<Player> queuedPlayers, Kit kit){
        this.queuedPlayers = queuedPlayers;
        this.kit = kit;
    }

    public Set<Player> getQueuedPlayers() {
        return queuedPlayers;
    }

    public void setQueuedPlayers(HashSet<Player> queuedPlayers) {
        this.queuedPlayers = queuedPlayers;
    }

    public Kit getKit() {
        return kit;
    }

    public void setKit(Kit kit) {
        this.kit = kit;
    }
}
