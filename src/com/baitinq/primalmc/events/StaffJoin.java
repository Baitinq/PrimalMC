package com.baitinq.primalmc.events;

import com.baitinq.primalmc.Main;
import com.baitinq.primalmc.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StaffJoin implements Listener{

    private static Main plugin;
    public StaffJoin(Main plugin){
        this.plugin = plugin;
    }
    String staffprefix = plugin.STAFF;
    String prefix = plugin.PREFIX;
    @EventHandler
    public void StaffJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("primalmc.staff")){
            Bukkit.getServer().broadcast(prefix+ ChatColor.GOLD+player+ChatColor.GRAY+" has joined the server.", "primalmc.staff");



        }
    }
}