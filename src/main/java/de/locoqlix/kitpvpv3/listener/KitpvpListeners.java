package de.locoqlix.kitpvpv3.listener;

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import de.locoqlix.kitpvpv3.utils.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class KitpvpListeners implements Listener {



    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(2024);
        player.sendTitle("§lWillkommen bei", "§l§aKitPVP");
        event.setJoinMessage("§l§7[§2+§7] §r§l" + player.getName());
    }

    @EventHandler
    public void onLeaveEvent(PlayerQuitEvent event){
        Player player = event.getPlayer();
        player.getInventory().clear();
        event.setQuitMessage("§l§7[§4-§7] §r§l" + player.getName());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        event.getDrops().removeAll(event.getDrops());
        event.setNewLevel(2024);
        event.setKeepInventory(true);
        if (CoinsAPI.getCoins(player) >= 25) {
            int coins = CoinsAPI.getCoins(player);
            CoinsAPI.removeCoins(player, coins);
            Messages.informPlayer(player, "§cDu hast §6" + coins + " coins §cverloren");
        } else {
            CoinsAPI.removeCoins(player, 25);
            Messages.informPlayer(player, "§cDu hast §625 coins §cverloren");
        }
        if (event.getEntity().getKiller() instanceof Player) {
            Player killer = event.getEntity().getKiller().getPlayer();
            CoinsAPI.addCoins(killer, 25);
            Messages.informPlayer(killer, "§aDu hast §625 coins §abekommen!!");
            killer.setHealth(20);
            killer.setFoodLevel(20);
        }

    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        player.setHealth(20);
        player.setFoodLevel(20);
    }


    @EventHandler
    public void dropEvent(PlayerDropItemEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void repairItem(PlayerItemDamageEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void pickupItem(PlayerPickupItemEvent event){
        event.setCancelled(true);
    }

}
