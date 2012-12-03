package de.soxra.bukkit.Scarest;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ShootArrow implements Listener {

    private Scarest plugin;
    private SkeletonUtils su = new SkeletonUtils();

    public ShootArrow(Scarest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (su.isSkelet(player)) {
            if (su.arrowHasDamage(player)) {
                player.shootArrow();
                player.getWorld().playEffect(player.getLocation(), Effect.BOW_FIRE, 50);
            } else {
                player.shootArrow();
                player.getWorld().playEffect(player.getLocation(), Effect.BOW_FIRE, 50);
            }
        }
    }
}