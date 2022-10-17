package org.acsn1.practicecore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    private static String prefix = "&c&lPractice &8&l> ";
    
    public static String color(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void log(String msg){
        Bukkit.getConsoleSender().sendMessage(color(prefix + msg));
    }

    public static void msg(Player p, String msg){
        p.sendMessage(color(prefix + msg));
    }


}
