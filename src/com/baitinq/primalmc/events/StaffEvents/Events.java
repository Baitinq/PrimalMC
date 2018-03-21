package com.baitinq.primalmc.events.StaffEvents;

import com.baitinq.primalmc.Main;
import com.baitinq.primalmc.commands.StaffCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Events implements Listener {

    private static Main plugin;
    private static StaffCommand staffcmd;

    public Events(Main plugin){
        this.plugin = plugin;
    }

    //@EventHandler
    //public void PickupItem(PlayerPickupItemEvent event){
       // Player player = event.getPlayer();
        //if(plugin.staff.contains(player.getUniqueId())){
            //player.setCanPickupItems(false);
        //}
   // }

    public void PlayerInteractEntity(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        //if(plugin.staff.contains(player.getUniqueId())){
            event.setCancelled(true);
            player.sendMessage("You can not interact while vanished");

    }
    public void BlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        //if(plugin.getStaff().contains(player.getUniqueId()))
            event.setCancelled(true);
            player.sendMessage("You can not build while vanished");

    }

    public void BlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        //if(plugin.staff.contains(player.getUniqueId())){
        event.setCancelled(true);
        player.sendMessage("You can not build when vanished");

    }
}
