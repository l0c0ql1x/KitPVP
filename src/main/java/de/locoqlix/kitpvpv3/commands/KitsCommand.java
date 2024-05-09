package de.locoqlix.kitpvpv3.commands;

import de.locoqlix.kitpvpv3.KitPVP;
import de.locoqlix.kitpvpv3.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class KitsCommand implements CommandExecutor {

    private Inventory gui;

    public KitsCommand(KitPVP plugin) {

        int inventorySize = 9; // Check if one, two or three rows.

        gui = Bukkit.createInventory(null, inventorySize, "Kits");

        loadKits();
    }

    CommandSender unisender;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        unisender = sender;
        // Check if player
        if (!(sender instanceof Player)) {
            Messages.info("Nur Spieler dürfen den Command ausführen!!");
            return true;
        }

        Player player = (Player) sender;

        // Show available kits
        player.openInventory(gui);

        Messages.debug(player.getName() + " hat den 'kits' command ausgeführt.");
        Messages.informPlayer(player, "Loading kits...");
        return true;
    }

    private void loadKits(){

        ItemStack starter = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = starter.getItemMeta();
        meta.setDisplayName("§aStarter Kit");
        if (unisender.hasPermission("kitpvp.starter")){
            meta.setLore(Arrays.asList("§a§lGekauft", " "));
        }else {
            meta.setLore(Arrays.asList("§4§lGesperrt", "§e0 Coins"));
        }
        starter.setItemMeta(meta);
        gui.setItem(0, starter);

        ItemStack tank = new ItemStack(Material.IRON_BARS);
        ItemMeta meta1 = tank.getItemMeta();
        meta1.setDisplayName("§aTank");
        if (unisender.hasPermission("kitpvp.tank")){
            meta.setLore(Arrays.asList("§a§lGekauft", " "));
        }else {
            meta.setLore(Arrays.asList("§4§lGesperrt", "§e10000 Coins"));
        }
        tank.setItemMeta(meta1);
        gui.setItem(1, tank);

        ItemStack poseidon = new ItemStack(Material.TRIDENT);
        ItemMeta meta2 = poseidon.getItemMeta();
        meta2.setDisplayName("§aPosidon");
        if (unisender.hasPermission("kitpvp.poseidon")){
            meta.setLore(Arrays.asList("§a§lGekauft", " "));
        }else {
            meta.setLore(Arrays.asList("§4§lGesperrt", "§e2500 Coins"));
        }
        poseidon.setItemMeta(meta2);
        gui.setItem(2, poseidon);

        ItemStack archer = new ItemStack(Material.BOW);
        ItemMeta meta3 = archer.getItemMeta();
        meta3.setDisplayName("§aArcher");
        if (unisender.hasPermission("kitpvp.archer")){
            meta.setLore(Arrays.asList("§a§lGekauft", " "));
        }else {
            meta.setLore(Arrays.asList("§4§lGesperrt", "§e3500 Coins"));
        }
        archer.setItemMeta(meta3);
        gui.setItem(3, archer);

        ItemStack witch = new ItemStack(Material.SUSPICIOUS_STEW);
        ItemMeta meta4 = witch.getItemMeta();
        meta4.setDisplayName("§aWitch");
        if (unisender.hasPermission("kitpvp.witch")){
            meta.setLore(Arrays.asList("§a§lGekauft", " "));
        }else {
            meta.setLore(Arrays.asList("§4§lGesperrt", "§e4500 Coins"));
        }
        witch.setItemMeta(meta4);
        gui.setItem(4, witch);

        ItemStack fireman = new ItemStack(Material.CROSSBOW);
        ItemMeta meta5 = fireman.getItemMeta();
        meta5.setDisplayName("§aFireman");
        if (unisender.hasPermission("kitpvp.fireman")){
            meta.setLore(Arrays.asList("§a§lGekauft", " "));
        }else {
            meta.setLore(Arrays.asList("§4§lGesperrt", "§e7500 Coins"));
        }
        fireman.setItemMeta(meta5);
        gui.setItem(5, fireman);

        ItemStack magier = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta6 = magier.getItemMeta();
        meta6.setDisplayName("§aMagier");
        if (unisender.hasPermission("kitpvp.magier")){
            meta.setLore(Arrays.asList("§a§lGekauft", " "));
        }else {
            meta.setLore(Arrays.asList("§4§lGesperrt", "§e8000 Coins"));
        }
        magier.setItemMeta(meta6);
        gui.setItem(6, magier);

        ItemStack engel = new ItemStack(Material.FEATHER);
        ItemMeta meta7 = engel.getItemMeta();
        meta7.setDisplayName("§aEngel");
        if (unisender.hasPermission("kitpvp.engel")){
            meta.setLore(Arrays.asList("§a§lGekauft", " "));
        }else {
            meta.setLore(Arrays.asList("§4§lGesperrt", "§e20000 Coins"));
        }
        engel.setItemMeta(meta7);
        gui.setItem(7, engel);


    }



}
