package com.baitinq.primalmc.commands;

import com.baitinq.primalmc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.ibex.nestedvm.util.Platform;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class VanishCommand implements CommandExecutor{

    @SuppressWarnings( "deprecation" )

    private static Main plugin;

    //TODO PREFIX

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED+"This command is only executable by players.");
        }

        if(player.hasPermission("primalmc.staff")){
            if(!plugin.Vanished.contains(player.getUniqueId())){
                plugin.Vanished.add(player.getUniqueId());
                return true;
            }

            plugin.Vanished.remove(player.getUniqueId());
            return true;

        }

          player.sendMessage(ChatColor.RED+"You dont have permission to use this command.");

        return true;
    }
}


