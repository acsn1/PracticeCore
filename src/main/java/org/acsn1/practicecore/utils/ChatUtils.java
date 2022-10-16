package org.acsn1.practicecore.utils;

import org.bukkit.ChatColor;

public class ChatUtils {

    //translate & into colors.
    public static String color(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
