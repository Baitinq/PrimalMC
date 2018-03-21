package com.baitinq.primalmc.commands;

import com.baitinq.primalmc.Main;
import com.baitinq.primalmc.inventories.StaffInventory;
import com.sun.org.apache.xerces.internal.xs.datatypes.ByteList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;


public class StaffCommand implements CommandExecutor, Listener {

    @SuppressWarnings( "deprecation" )

    private static Main plugin;
    private static StaffInventory staffinv;
//TODO PREFIX

    ArrayList<UUID> staff= new ArrayList<UUID>();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED+"This command is only executable by players.");
        }
        Player player = (Player) sender;
        if(player.hasPermission("primalmc.staff")){
            if(!staff.contains(player.getUniqueId())){
                player.sendMessage(ChatColor.GOLD+"Staff Mode Enabled.");
                player.setGameMode(GameMode.CREATIVE);
                plugin.addToStaffMode(player);
               // player.getInventory();
               // staffinv.CreateInv(player);
                plugin.setVanished(player);


                return true;
            }
            player.sendMessage(ChatColor.GOLD+"Staff Mode Disabled.");
            player.setGameMode(GameMode.SURVIVAL);
            plugin.removeFromStaffMode(player);
            plugin.removeVanished(player);
            //player.getInventory().setContents();




        }
        else{
            player.sendMessage(ChatColor.RED+"You don't have permission to use this command.");

        } return true;
    }

    public void Vanish(Player player){
        for (Player p : Bukkit.getServer().getOnlinePlayers()){
            p.hidePlayer(player);
        }

    }

    public void UnVanish(Player player){
        for (Player p : Bukkit.getServer().getOnlinePlayers()){
            p.showPlayer(player);
        }

    }
}



