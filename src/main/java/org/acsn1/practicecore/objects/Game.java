package org.acsn1.practicecore.objects;


import org.acsn1.practicecore.managers.GameManager;
import org.bukkit.entity.Player;

public class Game {

    private Player[] gamePlayers;
    private Arena gameArena;
    private long gameStarted;
    private long gameEnded;
    private long id;

    public Game(Player[] gamePlayers, Arena gameArena, long gameStarted, long gameEnded){
        this.gamePlayers = gamePlayers;
        this.gameArena = gameArena;
        this.gameStarted = gameStarted;
        this.gameEnded = gameEnded;
        this.id = GameManager.generateGameId();
    }


    public Player[] getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Player[] gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public Arena getGameArena() {
        return gameArena;
    }

    public void setGameArena(Arena gameArena) {
        this.gameArena = gameArena;
    }

    public long getGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(long gameStarted) {
        this.gameStarted = gameStarted;
    }

    public long getGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(long gameEnded) {
        this.gameEnded = gameEnded;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
