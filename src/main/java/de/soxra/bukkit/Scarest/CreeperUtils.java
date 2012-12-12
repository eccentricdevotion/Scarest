package de.soxra.bukkit.Scarest;

import org.bukkit.entity.Player;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

public class CreeperUtils {

    public static boolean hasExplosion(Player player) {
        return ((Boolean) Scarest.isCreeper.get(player)).booleanValue();
    }

    public boolean isCreeper(Player player) {
        return Scarest.isCreeper.containsKey(player);
    }

    public void removeCreeper(Player player) {
        Scarest.isCreeper.remove(player);
        //MobDisguiseAPI.undisguisePlayer(player);
        if (Scarest.dcAPI.isDisguised(player) && Scarest.dcAPI.getDisguise(player).type == DisguiseType.Creeper) {
            Scarest.dcAPI.undisguisePlayer(player);
        }
    }

    public void addCreeper(Player player, Boolean bool) {
        Scarest.isCreeper.put(player, bool);
        //MobDisguiseAPI.disguisePlayer(player, "creeper");
        if (!Scarest.dcAPI.isDisguised(player)) {
            Scarest.dcAPI.disguisePlayer(player, new Disguise(Scarest.dcAPI.newEntityID(), DisguiseType.Creeper));
        }
        if (Scarest.dcAPI.isDisguised(player)) {
            Scarest.dcAPI.changePlayerDisguise(player, new Disguise(Scarest.dcAPI.newEntityID(), DisguiseType.Creeper));
        }
    }

    public void addRaduis(Player player, Integer Int) {
        Scarest.exRaduis.put(player, Int);
    }

    public void removeRadius(Player player) {
        Scarest.exRaduis.remove(player);
    }

    public int getRadius(Player player) {
        return ((Integer) Scarest.exRaduis.get(player)).intValue();
    }
}