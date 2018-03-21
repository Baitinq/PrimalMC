package com.baitinq.primalmc.inventories;

import com.baitinq.primalmc.Main;
import com.baitinq.primalmc.inventories.Items.StaffItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StaffInventory implements Listener{

    private static Main plugin;
    private static StaffItems items;

    public void StaffInv(Player player){
        Inventory staffinv = plugin.getServer().createInventory(null, 36, ChatColor.GOLD + "StaffInventory");
        //staffinv.setContents(items.VanishItem());

    }
}
