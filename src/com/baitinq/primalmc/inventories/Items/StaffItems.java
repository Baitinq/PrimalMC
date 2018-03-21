package com.baitinq.primalmc.inventories.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StaffItems implements Listener {

    public void VanishItem(Player player){
        ItemStack vanishitem = new ItemStack(Material.CAKE, 1);
        ItemMeta vanishmeta = vanishitem.getItemMeta();

        vanishmeta.setDisplayName(ChatColor.GREEN + "Vanish");

        ArrayList<String> vanishlore = new ArrayList<String>();
        vanishlore.add(ChatColor.YELLOW + "Right click this to get in and out of vanish!");

        vanishmeta.setLore(vanishlore);
        vanishitem.setItemMeta(vanishmeta);
    }

    public void AlertsItem(Player player){
        ItemStack alertsitem = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta alertsmeta = alertsitem.getItemMeta();

        alertsmeta.setDisplayName(ChatColor.RED + "Alerts");

        ArrayList<String> vanishlore = new ArrayList<String>();
        vanishlore.add(ChatColor.YELLOW + "Right click this to get enable and disable alerts");

        alertsmeta.setLore(vanishlore);
        alertsitem.setItemMeta(alertsmeta);
    }

}
