package org.acsn1.practicecore.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Arena {

    private String name;
    private Location location;
    private Location first;
    private Location second;
    private boolean isBuildable;
    private boolean isInUse;

    public Arena(String name, Location location, Location first, Location second, boolean isBuildable
    ,boolean isInUse){
        this.name = name;
        this.location = location;
        this.first = first;
        this.second = second;
        this.isBuildable = isBuildable;
        this.isInUse = isInUse;
    }

    public boolean isInUse() {
        return isInUse;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
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
