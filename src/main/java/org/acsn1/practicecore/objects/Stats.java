package org.acsn1.practicecore.objects;

public class Stats {

    private int wins;
    private int loses;

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
