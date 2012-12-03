package de.soxra.bukkit.Scarest;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireballThrow implements Listener {

    private Scarest plugin;
    private GhastUtils gu = new GhastUtils();
    private LangUtils lu = new LangUtils();

    public FireballThrow(Scarest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (gu.isGhast(player)) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR) {
                Block block = event.getClickedBlock();
                World world = player.getWorld();

                Location playerLoc = player.getLocation();
                Location loc = playerLoc.add(playerLoc.getDirection().normalize().multiply(3).toLocation(player.getWorld(), playerLoc.getYaw(), playerLoc.getPitch())).add(0.0D, 1.0D, 0.0D);
                Fireball f = (Fireball) world.spawn(loc, Fireball.class);
                world.playEffect(playerLoc, Effect.GHAST_SHOOT, 50);
                world.playEffect(playerLoc, Effect.GHAST_SHRIEK, 50);
                f.setYield(1.0F);

                if (!gu.hasBalldamage(player)) {
                    f.setIsIncendiary(false);
                } else {
                    f.setIsIncendiary(true);
                }
            }
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block block = event.getClickedBlock();
                World world = player.getWorld();

                Location playerLoc = player.getLocation();
                Location loc = playerLoc.add(playerLoc.getDirection().normalize().multiply(3).toLocation(player.getWorld(), playerLoc.getYaw(), playerLoc.getPitch())).add(0.0D, 1.0D, 0.0D);
                Fireball f = (Fireball) world.spawn(loc, Fireball.class);
                world.playEffect(playerLoc, Effect.GHAST_SHOOT, 50);
                world.playEffect(playerLoc, Effect.GHAST_SHRIEK, 50);

                f.setYield(1.0F);
                if (!gu.hasBalldamage(player)) {
                    f.setIsIncendiary(false);
                } else {
                    f.setIsIncendiary(true);
                }
            }
        }
    }
}