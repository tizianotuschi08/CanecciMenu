package org.example.com.canecciMenu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getCommand("caneccimenu").setExecutor(new MenuCommand(this));
        Bukkit.getPluginManager().registerEvents(new MenuListener(this), this);
        
        if (!(getDataFolder().exists())) {
            getDataFolder().mkdir();
        }
    
    }
    
}
