package de.locoqlix.kitpvpv3.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryMoveItem implements Listener {

    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent e) {
        if (e.getSource().getType() == InventoryType.CHEST && e.getSource().getHolder() == null) {
            e.setCancelled(true);
        }
    }
}
