package de.locoqlix.kitpvpv3;

import de.locoqlix.kitpvpv3.commands.CommandHandler;
import de.locoqlix.kitpvpv3.listener.EventHandler;
import de.locoqlix.kitpvpv3.utils.Messages;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitPVP extends JavaPlugin {

    public static FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();

        Messages.debug(config.getBoolean("debug"));


        // Load modules
        new CommandHandler(this);
        new EventHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
