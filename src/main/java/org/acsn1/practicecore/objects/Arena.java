package org.acsn1.practicecore.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Arena {

    private String name;
    private Location location;
    private Location first;
    private Location second;
    private Player[] players;
    private boolean isBuildable;

    public Arena(String name, Location location, Location first, Location second, Player[] players, boolean isBuildable){
        this.name = name;
        this.location = location;
        this.first = first;
        this.second = second;
        this.players = players;
        this.isBuildable = isBuildable;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public boolean isBuildable() {
        return isBuildable;
    }

    public void setBuildable(boolean buildable) {
        isBuildable = buildable;
    }

    public Location getFirst() {
        return first;
    }

    public void setFirst(Location first) {
        this.first = first;
    }

    public Location getSecond() {
        return second;
    }

    public void setSecond(Location second) {
        this.second = second;
    }
}
