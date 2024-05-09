package de.locoqlix.kitpvpv3.utils;

import de.locoqlix.kitpvpv3.KitPVP;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {

    private static final String CONSOLE_PREFIX = KitPVP.config.getString("consoleprefix");
    private static final String PREFIX = ChatColor.translateAlternateColorCodes('&', KitPVP.config.getString("prefix"));
    private static final String SUFFIX = ChatColor.translateAlternateColorCodes('&', KitPVP.config.getString("suffix"));

    private static boolean debug = false;

    // Player messages
    public static void informPlayer(Player player, String message) {
        player.sendMessage(PREFIX + SUFFIX + message);
    }

    // Console messages
    public static void info(String message) {
        System.out.println(CONSOLE_PREFIX + "[Info] " + message);
    }

    public static void warning(String message) {
        System.out.println(CONSOLE_PREFIX + "[Warning] " + message);
    }

    public static void error(String message) {
        System.out.println(CONSOLE_PREFIX + "[Error] " + message);
    }

    // Debug
    public static void debug(boolean enable) {
        debug = enable;
    }

    public static void debug(String message) {
        if (debug) {
            System.out.println(CONSOLE_PREFIX + "[Debug] " + message);
        }
    }
}
