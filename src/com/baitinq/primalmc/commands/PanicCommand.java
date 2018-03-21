package com.baitinq.primalmc.commands;

import com.baitinq.primalmc.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class PanicCommand implements CommandExecutor{

    private TeamspeakCommand plugin;

    ArrayList<Player> paniced = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.YELLOW+"This command is only executable by players.");
        }
        Player player = (Player) sender;


        return true;
    }


    public void PanicEvent(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(paniced.contains(player)){
            //añadir si tiene permiso pueda quitar de panick si no no
            paniced.remove(player);
            player.sendMessage(ChatColor.YELLOW+"You are no longer panicked.");
        }
        paniced.add(player);
        player.sendMessage(ChatColor.YELLOW+"You are in panick mode! Connect to" + ChatColor.GOLD+plugin.teamspeak);
    }
}
