package org.acsn1.practicecore.objects;

import java.io.Serializable;

public class Stats implements Serializable {

    private int wins;
    private int loses;

    public Stats(){
        this.wins = 0;
        this.loses = 0;
    }

    public Stats(int wins, int loses){
        this.wins = wins;
        this.loses = loses;
    }


    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }
}
