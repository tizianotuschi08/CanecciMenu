package org.example.com.canecciMenu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MenuTabComplete implements TabCompleter {
    
    
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        
        List<String> results = new ArrayList<>();
        
        if (strings.length == 1) {
            results.add("perm");
        }
        
        return results;
    }
}
