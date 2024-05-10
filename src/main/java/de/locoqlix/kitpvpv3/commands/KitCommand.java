package de.locoqlix.kitpvpv3.commands;

import de.locoqlix.kitpvpv3.KitPVP;
import de.locoqlix.kitpvpv3.utils.Messages;
import net.luckperms.api.LuckPerms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.locoqlix.kitpvpv3.Kits.*;


public class KitCommand implements CommandExecutor {

    private boolean kitFound;

    LuckPerms luckPerms;

    public KitCommand(KitPVP plugin) {
        kitFound = false;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        // Check if player
        if (!(commandSender instanceof Player)) {
            Messages.info("Nur Spieler dürfen den Command ausführen!!");
            return true;
        }

        Player player = (Player) commandSender;

        // Check if kit-name has been specified
        if (args.length == 0) {
            Messages.informPlayer(player, "Bitte nennen sie ein Kit.");
            Messages.informPlayer(player, "Command usage: /kit [name]");
            return true;
        }

        // Loop over kits

        if (args[0].equalsIgnoreCase("starter")) {
            player.getInventory().clear();
            if (player.hasPermission("kitpvp.starter")) {
                starterkit(player);
            }else {
                Messages.informPlayer(player, "§cDu besitzt den §l§6'Starter'§r§c kit nicht.");
                Messages.debug("Der Kit 'Starter' wurde den Spieler '" + player.getName() + "' nicht gegeben.");
                return true;
            }
            Messages.debug("Der Kit 'Starter' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Starter'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("tank")){
            player.getInventory().clear();
            if (player.hasPermission("kitpvp.tank")) {
                starterkit(player);
            }else {
                Messages.informPlayer(player, "§cDu besitzt den §l§6'Tank'§r§c kit nicht.");
                Messages.debug("Der Kit 'Tank' wurde den Spieler '" + player.getName() + "' nicht gegeben.");
                return true;
            }

            Messages.debug("Der Kit 'Tank' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Tank'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("poseidon")){
            player.getInventory().clear();
            if (player.hasPermission("kitpvp.poseidon")) {
                starterkit(player);
            }else {
                Messages.informPlayer(player, "§cDu besitzt den §l§6'Poseidon'§r§c kit nicht.");
                Messages.debug("Der Kit 'Poseidon' wurde den Spieler '" + player.getName() + "' nicht gegeben.");
                return true;
            }

            Messages.debug("Der Kit 'Poseidon' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Poseidon'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("archer")){
            player.getInventory().clear();
            if (player.hasPermission("kitpvp.starter")) {
                starterkit(player);
            }else {
                Messages.informPlayer(player, "§cDu besitzt den §l§6'Archer'§r§c kit nicht.");
                Messages.debug("Der Kit 'Archer' wurde den Spieler '" + player.getName() + "' nicht gegeben.");
                return true;
            }

            Messages.debug("Der Kit 'Archer' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Archer'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("witch")){
            player.getInventory().clear();
            if (player.hasPermission("kitpvp.witch")) {
                starterkit(player);
            }else {
                Messages.informPlayer(player, "§cDu besitzt den §l§6'Witch'§r§c kit nicht.");
                Messages.debug("Der Kit 'Witch' wurde den Spieler '" + player.getName() + "' nicht gegeben.");
                return true;
            }

            Messages.debug("Der Kit 'Witch' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Witch'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("fireman")){
            player.getInventory().clear();
            if (player.hasPermission("kitpvp.fireman")) {
                starterkit(player);
            }else {
                Messages.informPlayer(player, "§cDu besitzt den §l§6'Fireman'§r§c kit nicht.");
                Messages.debug("Der Kit 'Fireman' wurde den Spieler '" + player.getName() + "' nicht gegeben.");
                return true;
            }

            Messages.debug("Der Kit 'Fireman' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Fireman'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("magier")){
            player.getInventory().clear();
            if (player.hasPermission("kitpvp.magier")) {
                starterkit(player);
            }else {
                Messages.informPlayer(player, "§cDu besitzt den §l§6'Magier'§r§c kit nicht.");
                Messages.debug("Der Kit 'Magier' wurde den Spieler '" + player.getName() + "' nicht gegeben.");
                return true;
            }
            Messages.debug("Der Kit 'Magier' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Magier'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("engel")){
            player.getInventory().clear();
            if (player.hasPermission("kitpvp.engel")) {
                starterkit(player);
            }else {
                Messages.informPlayer(player, "§cDu besitzt den §l§6'Engel'§r§c kit nicht.");
                Messages.debug("Der Kit 'Engel' wurde den Spieler '" + player.getName() + "' gegeben.");
                return true;
            }

            Messages.debug("Der Kit 'Engel' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Engel'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }

        // Check if kit found
        if (!kitFound) {
            Messages.informPlayer(player, "Diesen Kit gibt es nicht.");
        }

        kitFound = false;
        return true;
    }



}
