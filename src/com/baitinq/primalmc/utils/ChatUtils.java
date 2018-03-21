package com.baitinq.primalmc.utils;

import com.baitinq.primalmc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    private static  Main plugin;

    public ChatUtils(Main plugin){
        this.plugin = plugin;
    }
    //translates the weird s to & in color codes
    public static String chat(String msg){
        return ChatColor.translateAlternateColorCodes('&',msg);
    }

    //sends a message to all players with "primalmc.staff" permission
    public static void StaffMsg(String message){
        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            if(player.hasPermission("primalmc.staff")){
                player.sendMessage(message);
            }
        }
    }
}
