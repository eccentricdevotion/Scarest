package de.soxra.bukkit.Scarest;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChewDoor implements Listener {

    private Scarest plugin;
    private ZombieUtils zu = new ZombieUtils();

    public ChewDoor(Scarest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();

        if (zu.isZombie(player)) {
            if ((event.getClickedBlock().getTypeId() == 64) && (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                World world = player.getWorld();
                Location loc = player.getLocation();

                world.playEffect(loc, Effect.ZOMBIE_CHEW_WOODEN_DOOR, 50);
            }

            if ((event.getClickedBlock().getTypeId() == 71) && (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                World world = player.getWorld();
                Location loc = player.getLocation();

                world.playEffect(loc, Effect.ZOMBIE_CHEW_IRON_DOOR, 50);
            }
            if (zu.canChew(player)) {
                if ((event.getClickedBlock().getTypeId() == 71) && (event.getAction() == Action.RIGHT_CLICK_BLOCK) && (!zu.isActive(player))) {
                    zu.addActive(player);
                    plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            Block block = event.getClickedBlock();
                            World world = player.getWorld();
                            Location loc = player.getLocation();

                            world.playEffect(loc, Effect.ZOMBIE_DESTROY_DOOR, 50);
                            block.setTypeId(0);

                            zu.removeActive(player);
                        }
                    }, 75L);
                }
                if ((event.getClickedBlock().getTypeId() == 64) && (event.getAction() == Action.RIGHT_CLICK_BLOCK) && (!zu.isActive(player))) {
                    zu.addActive(player);
                    plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            Block block = event.getClickedBlock();
                            World world = player.getWorld();
                            Location loc = player.getLocation();

                            world.playEffect(loc, Effect.ZOMBIE_DESTROY_DOOR, 50);
                            block.setTypeId(0);

                            zu.removeActive(player);
                        }
                    }, 75L);
                }
            }
        }
    }
}