package com.baitinq.primalmc.utils;

import com.baitinq.primalmc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

public class ConfigurationManager {

    private Main plugin = Main.getPlugin(Main.class);


    public FileConfiguration playerscfg;
    public File playersfile;

    public void setup(){

        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }
        playersfile = new File(plugin.getDataFolder(),"players.yml");

        if(!playersfile.exists()){
            try{
                playersfile.createNewFile();
            }catch (IOException e){
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"Could not create players.yml");
            }
        }
        playerscfg = YamlConfiguration.loadConfiguration(playersfile);
    }

    public FileConfiguration getPlayers() {
        return playerscfg;
    }

    public void SavePlayers(){
        try{
            playerscfg.save(playersfile);

        }catch (IOException e){
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"Could not save players.yml");
        }
    }
    public void ReloadPlayers(){
        try{
            playerscfg = YamlConfiguration.loadConfiguration(playersfile);

        }catch(IOError e){

            playerscfg = YamlConfiguration.loadConfiguration(playersfile);
        }
    }
}
