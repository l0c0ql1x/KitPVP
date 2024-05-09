package de.locoqlix.kitpvpv3.commands;

import de.locoqlix.kitpvpv3.KitPVP;

public class CommandHandler {

    public CommandHandler(KitPVP plugin) {

        // Set executors
        plugin.getCommand("kits").setExecutor(new KitsCommand(plugin));
        plugin.getCommand("kit").setExecutor(new KitCommand(plugin));
    }
}
