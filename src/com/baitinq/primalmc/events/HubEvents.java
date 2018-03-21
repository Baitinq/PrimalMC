package com.baitinq.primalmc.events;

import com.baitinq.primalmc.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class HubEvents implements Listener {

    private static Main plugin;


    //anti mob-spawn
    public void MobSpawn(final EntitySpawnEvent event){
        if(plugin.getConfig().getBoolean("hub", true)){
            event.setCancelled(true);
        }
    }

    //no damage in hub
    public void Damage(final EntityDamageByEntityEvent event){
        if(plugin.getConfig().getBoolean("hub", true)){
            event.setCancelled(true);
        }
    }
    //no burning in hub
    public void CombustEvent(final EntityCombustEvent event){
        if(plugin.getConfig().getBoolean("hub", true)){
            event.setCancelled(true);
        }
    }
    //tp to Spawn if they fall into void
    public void VoidFall(final EntityDamageEvent event){
        Player player = (Player) event.getEntity();
        if(plugin.getConfig().getBoolean("hub", true)){
            if(event.getCause().equals(EntityDamageEvent.DamageCause.VOID) && event.getEntity().equals(player)){
                player.teleport(player.getWorld().getSpawnLocation());
            }
        }
    }

    //doublejump method
    @EventHandler
    public void DoubleJump(final PlayerMoveEvent event){
        Player player = (Player) event.getPlayer();
        if(plugin.getConfig().getBoolean("doublejump", true)){
            if((player.getGameMode()!=GameMode.CREATIVE) && (player.getLocation().subtract(0, 1, 0).getBlock().getType()!= Material.AIR) && (!player.isFlying())){
            player.setAllowFlight(true);
            }
        }

    }
    //actual double jump
    @EventHandler
    public void DoubleJumpUtil(final PlayerToggleFlightEvent event){
        Player player = (Player) event.getPlayer();
        if(plugin.getConfig().getBoolean("doublejump", true)){
            if(player.getGameMode()==GameMode.CREATIVE){
            return;
            }
            event.setCancelled(true);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));

        }
    }

}
