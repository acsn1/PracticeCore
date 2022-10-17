package org.acsn1.practicecore.profile;

import org.acsn1.practicecore.objects.Stats;

import java.io.Serializable;
import java.util.UUID;

public class Profile implements Serializable {

    private String name;
    private UUID uuid;
    private Stats stats;

    public Profile(String name, UUID uuid, Stats stats){

        this.name = name;
        this.uuid = uuid;
        this.stats = stats;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
