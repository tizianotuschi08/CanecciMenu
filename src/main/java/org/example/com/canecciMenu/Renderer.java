package org.example.com.canecciMenu;

import org.bukkit.entity.Player;
import org.bukkit.map.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Renderer extends MapRenderer {
    
    @Override
    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
        
        mapCanvas.drawText(30, 20, MinecraftFont.Font ,"Canecci lover");
        
        try {
            BufferedImage image = ImageIO.read(new File("plugins/ManageMapsPlugin/canecci64.png"));
            mapCanvas.drawImage(32, 32, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}