package de.locoqlix.kitpvpv3.listener;

import de.locoqlix.kitpvpv3.KitPVP;
import de.locoqlix.kitpvpv3.commands.KitCommand;
import de.locoqlix.kitpvpv3.utils.Messages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class InventoryClick implements Listener {


    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        if (e.getInventory().getType() == InventoryType.CHEST && e.getInventory().getHolder() == null) {
            e.setCancelled(true);

            // Set target player
            Player player = (Player) e.getWhoClicked();

            if (e.getCurrentItem() != null) {
                // Check which kit is selected
                if (e.getCurrentItem().getType() == Material.IRON_SWORD){
                    KitCommand.starterkit(player);
                }else if (e.getCurrentItem().getType() == Material.IRON_BARS){
                    KitCommand.tankkit(player);
                }else if (e.getCurrentItem().getType() == Material.TRIDENT){
                    KitCommand.poseidonkit(player);
                }else if (e.getCurrentItem().getType() == Material.BOW){
                    KitCommand.archerkit(player);
                }else if (e.getCurrentItem().getType() == Material.SUSPICIOUS_STEW){
                    KitCommand.witchkit(player);
                }else if (e.getCurrentItem().getType() == Material.CROSSBOW){
                    KitCommand.firemankit(player);
                }else if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK){
                    KitCommand.magierkit(player);
                }else if (e.getCurrentItem().getType() == Material.FEATHER){
                    KitCommand.engelkit(player);
                }
            }
        }
    }
}