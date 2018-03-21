package com.baitinq.primalmc.events;

import com.baitinq.primalmc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstLogin implements Listener{

    private static Main plugin;
    public FirstLogin(Main plugin){
        this.plugin = plugin;
    }

    int players = plugin.getConfig().getInt("number");

    @EventHandler
    public void FirstLogin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore()){
            players++;
            Bukkit.getServer().broadcastMessage(plugin.PREFIX+ChatColor.GOLD+""+ player +ChatColor.YELLOW +"has joined the server"+" ("+ChatColor.DARK_GRAY+players+"#"+ChatColor.GRAY+")");
            plugin.saveConfig();
            plugin.reloadConfig();
        }
    }


}
