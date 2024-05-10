package de.locoqlix.kitpvpv3.listener;

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import de.locoqlix.kitpvpv3.KitPVP;
import de.locoqlix.kitpvpv3.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class KitpvpListeners implements Listener {

    private HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(2024);
        player.sendTitle("§lWillkommen bei", "§l§aKitPVP");
        event.setJoinMessage("§l§7[§2+§7] §r§l" + player.getName());
        player.getInventory().clear();
    }

    @EventHandler
    public void onLeaveEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();
        event.setQuitMessage("§l§7[§4-§7] §r§l" + player.getName());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        event.getDrops().removeAll(event.getDrops());
        event.setNewLevel(2024);
        player.getInventory().clear();
        int coins = 25;
        if (CoinsAPI.getCoins(player) <= 25) {
            coins = CoinsAPI.getCoins(player);
            CoinsAPI.removeCoins(player, coins);
            Messages.informPlayer(player, "§cDu hast §6" + coins + " coins §cverloren");
        } else {
            CoinsAPI.removeCoins(player, coins);
            Messages.informPlayer(player, "§cDu hast §6" + coins + " coins §cverloren");
        }
        if (event.getEntity().getKiller() instanceof Player && !(event.getEntity().getKiller() == player)) {
            Player killer = event.getEntity().getKiller().getPlayer();
            CoinsAPI.addCoins(killer, coins);
            Messages.informPlayer(killer, "§aDu hast §6" + coins + " coins §abekommen!!");
            killer.setHealth(20);
            killer.setFoodLevel(20);
            killer.getWorld().playSound(killer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
        }
        event.setDeathMessage("§l§c" + event.getEntity().getKiller().getName() + " §r§7killed §l§c" + player.getName());

    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        player.setHealth(20);
        player.setFoodLevel(20);
    }


    @EventHandler
    public void dropEvent(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void repairItem(PlayerItemDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void pickupItem(PlayerPickupItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onCancelFallDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void clickEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().getType() == Material.ENCHANTED_BOOK) {
                if (cooldown.containsKey(player.getUniqueId()) && cooldown.get(player.getUniqueId()) > System.currentTimeMillis()) {
                    event.setCancelled(true);
                    long remainingTime = cooldown.get(player.getUniqueId()) - System.currentTimeMillis();
                    Messages.informPlayer(player, "§cWarte noch §r§l§e" + remainingTime / 1000 + " §r§cSekunden");
                } else {
                    cooldown.put(player.getUniqueId(), System.currentTimeMillis() + (2 * 1000));

                    Fireball fire = player.getWorld().spawn(player.getEyeLocation(), Fireball.class);
                    fire.setFireTicks(0);
                    fire.setShooter(player);

                }
            }
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (player.getItemInHand().getType() == Material.FEATHER) {
                    if (cooldown.containsKey(player.getUniqueId()) && cooldown.get(player.getUniqueId()) > System.currentTimeMillis()) {
                        event.setCancelled(true);
                        long remainingTime = cooldown.get(player.getUniqueId()) - System.currentTimeMillis();
                        Messages.informPlayer(player, "§cWarte noch §r§l§e" + remainingTime / 1000 + " §r§cSekunden");
                    } else {
                        cooldown.put(player.getUniqueId(), System.currentTimeMillis() + (2 * 1000));
                        Vector direction = event.getPlayer().getLocation().getDirection().normalize();
                        double pitch = event.getPlayer().getLocation().getPitch();
                        double yaw = event.getPlayer().getLocation().getYaw();
                        double pitchAngle = Math.toRadians(pitch);
                        double yawAngle = Math.toRadians(yaw);
                        double pitchOffset = 0.0;
                        if (pitchAngle > 0.5) {
                            pitchOffset = 1.0;
                        } else if (pitchAngle < -0.5) {
                            pitchOffset = -1.0;
                        }
                        double zOffset = pitchOffset * Math.sin(yawAngle);
                        direction.setZ(direction.getZ() + zOffset * 1.5);
                        event.getPlayer().setVelocity(direction.multiply(2.5));
                        event.getPlayer().setAllowFlight(true);
                        event.getPlayer().setFlying(true);
                        Bukkit.getPluginManager().getPlugin("KitPVP").getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("KitPVP"), new Runnable() {
                            @Override
                            public void run() {
                                event.getPlayer().setAllowFlight(false);
                                event.getPlayer().setFlying(false);
                            }
                        }, 2L);
                    }
                }
            }
        }
    }

}
