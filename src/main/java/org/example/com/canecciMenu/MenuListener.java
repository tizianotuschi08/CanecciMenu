package org.example.com.canecciMenu;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class MenuListener implements Listener {
    
    private Main main;
    public MenuListener(Main main) {
        this.main = main;
    }
    
    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e) {
    
        if(ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.LIGHT_PURPLE + "Canecci Menu")) {
            if (e.getCurrentItem() == null) return;
            e.setCancelled(true);
            
            Player player = (Player) e.getWhoClicked();
            
            int ItemClicked = e.getRawSlot();
            
            switch (ItemClicked) {
                
                case 0:
                    
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                    break;
                case 20: // give canecci sword
                    
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1f, 1f);
                    
                    // Set up canecci sword
                    ItemStack canecciSwordItem = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta canecciSwordItemMeta = canecciSwordItem.getItemMeta();
                    canecciSwordItemMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Canecci Sword");
                    canecciSwordItemMeta.setLore(Arrays.asList(ChatColor.GRAY + "This is a very powerful sword!"));
                    NamespacedKey swordKey = new NamespacedKey(main, "sword");
                    AttributeModifier attackDamage = new AttributeModifier(swordKey.getKey(), 50, AttributeModifier.Operation.ADD_NUMBER);
                    canecciSwordItemMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, attackDamage);
                    canecciSwordItemMeta.setUnbreakable(true);
                    canecciSwordItem.setItemMeta(canecciSwordItemMeta);
                    
                    player.getInventory().addItem(canecciSwordItem);
                    player.sendMessage(ChatColor.GREEN + "Hai ricevuto la Canecci Sword!");
                    
                    break;
                case 22: // give canecci potion
                    
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1f, 1f);
                    
                    // Set up Canecci Potion
                    ItemStack canecciPotionItem = new ItemStack(Material.POTION);
                    PotionMeta canecciPotionItemMeta = (PotionMeta) canecciPotionItem.getItemMeta();
                    canecciPotionItemMeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Canecci Potion");
                    canecciPotionItemMeta.setLore(Arrays.asList(ChatColor.GRAY + "This is a very powerful potion!"));
                    PotionEffect customEffect = new PotionEffect(PotionEffectType.JUMP_BOOST, 1200, 20, false, true);
                    canecciPotionItemMeta.addCustomEffect(customEffect, true);
                    canecciPotionItem.setItemMeta(canecciPotionItemMeta);
                    
                    player.getInventory().addItem(canecciPotionItem);
                    player.sendMessage(ChatColor.GREEN + "Hai ricevuto la Canecci Potion!");
                    
                    break;
                case 24: // give canecci map
                    
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1f, 1f);
                    
                    ItemStack mapItem = new ItemStack(Material.FILLED_MAP);
                    MapView mapView = Bukkit.createMap(player.getWorld());
                    for(MapRenderer rendere :  mapView.getRenderers()) {
                        mapView.removeRenderer(rendere);
                    }
                    mapView.addRenderer(new Renderer());
                    MapMeta mapMeta = (MapMeta) mapItem.getItemMeta();
                    mapMeta.setDisplayName(ChatColor.YELLOW.toString() + ChatColor.BOLD + "Canecci Map!");
                    mapMeta.setLore(Arrays.asList(ChatColor.GRAY + "This is a very funny map!"));
                    mapMeta.setMapView(mapView);
                    mapItem.setItemMeta(mapMeta);
                    
                    player.getInventory().addItem(mapItem);
                    player.sendMessage(ChatColor.GREEN + "Hai ricevuto la Canecci Map!");
                    
                    break;
                default:
                    return;
                
            }
            
            player.closeInventory();
        }
    
    }
}
