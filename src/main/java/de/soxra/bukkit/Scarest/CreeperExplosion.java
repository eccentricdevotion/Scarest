package de.soxra.bukkit.Scarest;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class CreeperExplosion implements Listener {

    private Scarest plugin;
    private CreeperUtils cu = new CreeperUtils();

    public CreeperExplosion(Scarest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();

        if (cu.isCreeper(player)) {
            if (event.isSneaking()) {
                if (CreeperUtils.hasExplosion(player)) {
                    int radius = cu.getRadius(player);
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    world.createExplosion(loc, radius);
                } else {
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    world.createExplosion(loc, 0.0F);
                }
            }
        }
    }
}