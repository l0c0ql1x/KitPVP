package de.locoqlix.kitpvpv3.listener;

import de.locoqlix.kitpvpv3.KitPVP;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventHandler {
    public EventHandler(KitPVP plugin) {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new InventoryClick(), plugin);
        pm.registerEvents(new InventoryDrag(), plugin);
        pm.registerEvents(new InventoryMoveItem(), plugin);
        pm.registerEvents(new InventoryPickUpItem(), plugin);
        pm.registerEvents(new KitpvpListeners(), plugin);
    }
}
