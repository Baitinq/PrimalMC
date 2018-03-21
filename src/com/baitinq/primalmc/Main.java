package com.baitinq.primalmc;

import com.baitinq.primalmc.commands.*;
import com.baitinq.primalmc.events.HubEvents;
import com.baitinq.primalmc.inventories.StaffInventory;
import com.baitinq.primalmc.utils.ChatUtils;
import com.baitinq.primalmc.utils.ConfigurationManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import com.baitinq.primalmc.events.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.UUID;

@Getter
public class Main extends JavaPlugin implements Listener, CommandExecutor{

    @SuppressWarnings( "deprecation" )

    private ConfigurationManager cfg;
    private StaffCommand staffcmd;
    private StaffInventory staffinv;

    @Getter public String PREFIX = ChatUtils.chat(ChatColor.GOLD+""+ChatColor.BOLD+"PrimalMC»");
    @Getter public String STAFF = ChatUtils.chat(ChatColor.GRAY+"["+ChatColor.GOLD+ChatColor.BOLD+"Staff"+ChatColor.RESET+ChatColor.GRAY+"]");

    @Getter public String staffpermission = "primalmc.staff";

    //List of Online Staff
    @Getter public ArrayList<UUID> Staff = new ArrayList<UUID>();

    @Getter public ArrayList<UUID> Vanished = new ArrayList<UUID>();


    @Override
    public void onEnable(){
        loadEvents();
        loadCMD();
        LoadConfig();
    }
    @Override
    public void onDisable(){
        saveConfig();
    }

    public void LoadConfig(){
        LoadConfigManager();
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }
    //ConfigManager (Config.yml reload, save, etc)
    public void LoadConfigManager(){
        cfg = new ConfigurationManager();
        cfg.setup();
        cfg.SavePlayers();
        cfg.ReloadPlayers();
    }
//loadCommands (Clean up onEnable)
    public void loadCMD(){
        getCommand("staff").setExecutor(new StaffCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("website").setExecutor(new WebsiteCommand());
        getCommand("teamspeak").setExecutor(new TeamspeakCommand());
        getCommand("store").setExecutor(new StoreCommand());
//loadEvents (Clean up onEnable)
    }
    public void loadEvents(){

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new HubEvents(), this);
    }

    //void to add to staff
    public void addToStaffMode(Player player){
        Staff.add(player.getUniqueId());
    }
    //void remove from staff
    public void removeFromStaffMode(Player player){
        Staff.remove(player.getUniqueId());
    }
    //void vanish the player
    public void setVanished(Player player){
        Vanished.add(player.getUniqueId());
        for(Player p : Bukkit.getServer().getOnlinePlayers()){
            p.hidePlayer(player);
        }
    }
    //void unvanish the player
    public void removeVanished(Player player){
        Vanished.remove(player.getUniqueId());
        for(Player p : Bukkit.getServer().getOnlinePlayers()){
            p.showPlayer(player);
        }
    }
    //set the staff inv
   // public void giveStaffInv(Player player){
    //    StaffInventory i = new StaffInventory();
    //    i.
    //}
}










