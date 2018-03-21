package com.baitinq.primalmc.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WebsiteCommand implements CommandExecutor{

    private String website = "www.primalmc.com";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED+"Only executable by players.");
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.YELLOW+"The PrimalMC Website is "+ChatColor.GOLD+ website);


        return true;
    }
}
