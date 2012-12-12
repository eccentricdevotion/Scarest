package de.soxra.bukkit.Scarest;

import org.bukkit.entity.Player;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

public class GhastUtils {

    public void addGhast(Player player, Boolean bool) {
        Scarest.isGhast.put(player, bool);
        //MobDisguiseAPI.disguisePlayer(player, "ghast");
        if (!Scarest.dcAPI.isDisguised(player)) {
            Scarest.dcAPI.disguisePlayer(player, new Disguise(Scarest.dcAPI.newEntityID(), DisguiseType.Ghast));
        }
        if (Scarest.dcAPI.isDisguised(player)) {
            Scarest.dcAPI.changePlayerDisguise(player, new Disguise(Scarest.dcAPI.newEntityID(), DisguiseType.Ghast));
        }
    }

    public void removeGhast(Player player) {
        Scarest.isGhast.remove(player);
        //MobDisguiseAPI.undisguisePlayer(player);
        if (Scarest.dcAPI.isDisguised(player) && Scarest.dcAPI.getDisguise(player).type == DisguiseType.Ghast) {
            Scarest.dcAPI.undisguisePlayer(player);
        }
    }

    public boolean hasBalldamage(Player player) {
        return ((Boolean) Scarest.isGhast.get(player)).booleanValue();
    }

    public boolean isGhast(Player player) {
        return Scarest.isGhast.containsKey(player);
    }
}