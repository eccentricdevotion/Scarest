package de.soxra.bukkit.Scarest;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LogoutEvent implements Listener {

    private Scarest plugin;
    private CreeperUtils cu = new CreeperUtils();
    private IrongolemUtils iu = new IrongolemUtils();
    private ZombieUtils zu = new ZombieUtils();

    public LogoutEvent(Scarest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (cu.isCreeper(player)) {
            cu.removeCreeper(player);
            cu.removeRadius(player);
        }

        if (iu.isGolem(player)) {
            iu.removeGolem(player);
        }

        if (zu.isZombie(player)) {
            zu.removeZombie(player);
        }
    }
}