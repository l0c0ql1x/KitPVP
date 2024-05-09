package de.locoqlix.kitpvpv3.commands;

import de.locoqlix.kitpvpv3.KitPVP;
import de.locoqlix.kitpvpv3.utils.Messages;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;


public class KitCommand implements CommandExecutor {

    private boolean kitFound;

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
            starterkit(player);

            Messages.debug("Der Kit 'Starter' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Starter'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("tank")){
            player.getInventory().clear();
            tankkit(player);

            Messages.debug("Der Kit 'Tank' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Tank'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("poseidon")){
            player.getInventory().clear();
            poseidonkit(player);

            Messages.debug("Der Kit 'Poseidon' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Poseidon'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("archer")){
            player.getInventory().clear();
            archerkit(player);

            Messages.debug("Der Kit 'Archer' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Archer'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("witch")){
            player.getInventory().clear();
            witchkit(player);

            Messages.debug("Der Kit 'Witch' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Witch'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("fireman")){
            player.getInventory().clear();
            firemankit(player);

            Messages.debug("Der Kit 'Fireman' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Fireman'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("magier")){
            player.getInventory().clear();
            magierkit(player);


            Messages.debug("Der Kit 'Magier' wurde den Spieler '" + player.getName() + "' gegeben.");
            Messages.informPlayer(player, "§aDu hast den §l§6'Magier'§r§a kit bekommen.");

            kitFound = true;
            return true;
        }else if (args[0].equalsIgnoreCase("engel")){
            player.getInventory().clear();
            engelkit(player);

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

    public static void starterkit(Player player){
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
        player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,16));
        player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
    }

    public static void tankkit(Player player){
        player.getInventory().clear();
        ItemStack wooden_sword = new ItemStack(Material.WOODEN_SWORD);
        wooden_sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        player.getInventory().addItem(wooden_sword);
        player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,32));
        player.getInventory().addItem(new ItemStack(Material.SHIELD));
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        player.getInventory().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
    }

    public static void poseidonkit(Player player){
        player.getInventory().clear();
        ItemStack wooden_sword = new ItemStack(Material.WOODEN_SWORD);
        wooden_sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemStack trident = new ItemStack(Material.TRIDENT);
        trident.addEnchantment(Enchantment.RIPTIDE, 1);
        player.getInventory().addItem(wooden_sword);
        player.getInventory().addItem(trident);
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
        player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,32));
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
        player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
    }

    public static void archerkit(Player player){
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
        player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
        player.getInventory().addItem(new ItemStack(Material.BAKED_POTATO, 32));
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
        ItemStack chainmail_leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemStack chainmail_boots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemStack chainmail_chesplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack chainmail_helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        chainmail_helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
        chainmail_boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
        chainmail_chesplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
        chainmail_leggings.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
        player.getInventory().setBoots(chainmail_boots);
        player.getInventory().setChestplate(chainmail_chesplate);
        player.getInventory().setLeggings(chainmail_leggings);
        player.getInventory().setHelmet(chainmail_helmet);
        player.getInventory().addItem(new ItemStack(Material.ARROW));
    }

    public static void witchkit(Player player){
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
        player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
        Potion instantheal = new Potion(PotionType.INSTANT_HEAL, 2);
        instantheal.setSplash(true);
        player.getInventory().addItem(instantheal.toItemStack(2));
        Potion instantdamage = new Potion(PotionType.INSTANT_DAMAGE, 1);
        instantdamage.setSplash(true);
        player.getInventory().addItem(instantdamage.toItemStack(2));
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
        player.getInventory().addItem(new ItemStack(Material.COOKED_COD, 32));
        ItemStack leatherChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        leatherChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        player.getInventory().setChestplate(leatherChestplate);
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
    }

    public static void firemankit(Player player){
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
        ItemStack crossbow = new ItemStack(Material.CROSSBOW);
        crossbow.addEnchantment(Enchantment.QUICK_CHARGE, 3);
        player.getInventory().addItem(crossbow);
        ItemStack chainmailChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        chainmailChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 32));
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
        player.getInventory().addItem(new ItemStack(Material.ARROW, 128));
        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        player.getInventory().setChestplate(chainmailChestplate);
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
    }

    public static void magierkit(Player player){
        player.getInventory().clear();
        ItemStack wooden_sword = new ItemStack(Material.WOODEN_SWORD);
        wooden_sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        player.getInventory().addItem(wooden_sword);
        player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 32));
        ItemStack fireAspect = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta)fireAspect.getItemMeta();
        meta.addStoredEnchant(Enchantment.FIRE_ASPECT, 1, true);
        fireAspect.setItemMeta(meta);
        player.getInventory().addItem(fireAspect);
        ItemStack leatherHelmet = new ItemStack(Material.LEATHER_HELMET);
        leatherHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemStack leatherLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
        leatherLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1 );
        player.getInventory().setHelmet(leatherHelmet);
        player.getInventory().setLeggings(leatherLeggings);
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
        player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
        Potion instantheal = new Potion(PotionType.INSTANT_HEAL, 2);
        player.getInventory().addItem(instantheal.toItemStack(2));
        Potion instantdamage = new Potion(PotionType.SPEED, 2);
        player.getInventory().addItem(instantdamage.toItemStack(2));
    }

    public static void engelkit(Player player){
        player.getInventory().clear();
        ItemStack golden_sword = new ItemStack(Material.GOLDEN_SWORD);
        golden_sword.addEnchantment(Enchantment.SWEEPING_EDGE, 1);
        player.getInventory().addItem(golden_sword);
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_AXE));
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 32));
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
        player.getInventory().setItem(8,new ItemStack(Material.TOTEM_OF_UNDYING));
        player.getInventory().setItem(7,new ItemStack(Material.FEATHER));
        player.getInventory().setHelmet(new ItemStack(Material.GOLDEN_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.GOLDEN_BOOTS));
    }

}