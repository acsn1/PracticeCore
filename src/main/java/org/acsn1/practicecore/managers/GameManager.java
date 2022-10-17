package org.acsn1.practicecore.managers;

import org.acsn1.practicecore.PracticeCore;
import org.acsn1.practicecore.objects.Game;
import org.acsn1.practicecore.utils.ChatUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class GameManager {

    private static HashSet<Game> GAMES;
    private PracticeCore core;
    public GameManager(PracticeCore core){
        this.core = core;
        GAMES = new HashSet<>();
    }

    public static String generateGameId(){
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        String out = "";


        do {
            out += chars.charAt(ThreadLocalRandom.current().nextInt(0, chars.length()-1));
        } while(out.length() <= 7);
        return out;
    }

    public void addGame(Game game){
        if(gameExists(game)) return;

        do{
            game.setGameArena(core.getArenaManager().getRandomArena());
        } while(game.getGameArena().isInUse());

        game.getGameArena().setInUse(true);
        GAMES.add(game);

        Location first = game.getGameArena().getFirst();
        Location second = game.getGameArena().getSecond();
        Player player1 = game.getGamePlayers()[0];
        Player player2 = game.getGamePlayers()[1];

        //player1.teleport(first);
        //player2.teleport(second);

        for(Player gamePlayers:game.getGamePlayers()){
            ChatUtils.msg(gamePlayers, "&aMatch has been found.");
            ChatUtils.msg(gamePlayers, "&cOpponent: &f" + gamePlayers.getName());
        }


    }

    public boolean gameExists(Game game){
        for(Game live_games:GAMES){
            if(live_games.getId() == game.getId()){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }

    public void deleteGame(Game game, Player winner){
        if(!gameExists(game)) return;

        GAMES.remove(game);

        //Spawn TP gamePlayers.
        //Reset inventories
        //reset arenas/games
        game.getGameArena().setInUse(false);
        game.setGameEnded(System.currentTimeMillis());

        Player player1 = game.getGamePlayers()[0];
        Player loser;
        if(player1.equals(winner)){
            loser = game.getGamePlayers()[1];
        } else{
            loser = player1;
        }

        for(Player gamePlayers:game.getGamePlayers()){
            ChatUtils.msg(gamePlayers, "&cMatch was ended!");
            ChatUtils.msg(gamePlayers, "&aWinner: &f" + winner.getName() + "&8- &cLoser: &f" + loser.getName());
        }

    }

    public Game getGame(long id){
        for(Game live_games:GAMES){
            if(live_games.getId().equals(id)){
                return live_games;
            }
        }
        return null;
    }

    public Game getGame(Player p){
        for(Game live_games:GAMES){
            if(live_games.getGamePlayers()[0].equals(p)){
                return live_games;
            } else if(live_games.getGamePlayers()[1].equals(p)){
                return live_games;
            } else{
                return null;
            }
        }

        return null;
    }




}
