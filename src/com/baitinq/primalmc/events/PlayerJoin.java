package com.baitinq.primalmc.events;

import com.baitinq.primalmc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import com.baitinq.primalmc.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private static Main plugin;

    @EventHandler
    public void JoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("");
        player.sendMessage(ChatColor.GOLD+"       PrimalMC");
        player.sendMessage(ChatColor.YELLOW+""+ChatColor.STRIKETHROUGH+"----------------------------");
        player.sendMessage(ChatColor.GOLD+"www.primalmc.com");
        player.sendMessage(ChatColor.GOLD+"ts.primalmc.net");
        player.sendMessage(ChatColor.GOLD+"store.primalmc.com");
        player.sendMessage(ChatColor.YELLOW+""+ChatColor.STRIKETHROUGH+"----------------------------");


    }


}
