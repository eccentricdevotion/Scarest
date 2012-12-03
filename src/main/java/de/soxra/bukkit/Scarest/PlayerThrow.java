package de.soxra.bukkit.Scarest;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.Vector;

public class PlayerThrow implements Listener {

    private Scarest plugin;
    private IrongolemUtils iu = new IrongolemUtils();

    public PlayerThrow(Scarest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerClickPlayer(PlayerInteractEntityEvent event) {
        Entity e = event.getRightClicked();
        Player player = event.getPlayer();
        if (((e instanceof Player))
                && (iu.isGolem(player)) && (iu.canHit(player)) && (player.isSneaking())) {
            Player target = (Player) e;
            target.damage(5);
            Vector dir = player.getLocation().getDirection().multiply(1.0D);
            Vector vec = new Vector(dir.getX(), 0.8D, dir.getZ());
            target.setVelocity(vec);
        }
    }
}