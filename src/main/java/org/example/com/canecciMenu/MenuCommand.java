package org.example.com.canecciMenu;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.UUID;

public class MenuCommand implements CommandExecutor {
    
    private Main main;
    
    public MenuCommand(Main main) {
        this.main = main;
    }
    
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player));
        Player player = (Player) commandSender;
        
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
        
        Inventory inventory = Bukkit.createInventory(player, 45, ChatColor.LIGHT_PURPLE + "Canecci Menu");
        
        // Set up Canecci Sword o menu
        ItemStack canecciSwordItem = new ItemStack(Material.DIAMOND_SWORD);// Set up sword meta
        ItemMeta canecciSwordMenuMeta = canecciSwordItem.getItemMeta();
        canecciSwordMenuMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Canecci Sword");
        canecciSwordMenuMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click here to recive Canecci Sword!"));
        canecciSwordItem.setItemMeta(canecciSwordMenuMeta);
        inventory.setItem(20, canecciSwordItem);
        
        // Set up Canecci Potion
        ItemStack canecciPotionItem = new ItemStack(Material.POTION);
        ItemMeta canecciPotionMenuMeta = canecciPotionItem.getItemMeta();
        canecciPotionMenuMeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Canecci Potion");
        canecciPotionMenuMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click here to recive Canecci Potion!"));
        canecciPotionItem.setItemMeta(canecciPotionMenuMeta);
        inventory.setItem(22, canecciPotionItem);
        
        // Set up Canecci Map
        ItemStack canecciMapItem = new ItemStack(Material.FILLED_MAP);
        MapMeta canecciMapMenuMeta = (MapMeta) canecciMapItem.getItemMeta();
        canecciMapMenuMeta.setDisplayName(ChatColor.YELLOW.toString() + ChatColor.BOLD + "Canecci Map");
        canecciMapMenuMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click here to recive Canecci Map!"));
        canecciMapItem.setItemMeta(canecciMapMenuMeta);
        inventory.setItem(24, canecciMapItem);
        
        // Set up close button
        ItemStack close = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta3 = (SkullMeta) close.getItemMeta();
        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());
        PlayerTextures texture = profile.getTextures();
        URL url;
        try {
            // URL della skin da applicare
            url = new URL("http://textures.minecraft.net/texture/797c6f29a950a9448949b3657d0dedc80709cbaa4c71451acdbe3886fc50d618");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        texture.setSkin(url);
        profile.setTextures(texture);
        meta3.setOwnerProfile(profile);
        // Imposta il nome dell'item
        meta3.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "Close");
        close.setItemMeta(meta3);
        inventory.setItem(0, close);                 // Posiziona nello slot 0
        
        // Set up borders
        ItemStack border = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta4 = border.getItemMeta();
        meta4.setDisplayName("");               // Nome vuoto per i bordi
        border.setItemMeta(meta4);
        // Posiziona l'item bordo in tutti gli slot indicati
        for (int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44}) {
            inventory.setItem(i, border);
        }
        
        player.openInventory(inventory);
        
        return false;
    }
}
