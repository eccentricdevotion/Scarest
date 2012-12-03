package de.soxra.bukkit.Scarest;

import org.bukkit.entity.Player;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

public class SkeletonUtils {

    public void addSkeleton(Player player, Boolean bool) {
        Scarest.isSkelet.put(player, bool);
        //MobDisguiseAPI.disguisePlayer(player, "skeleton");
        if (!Scarest.dcAPI.isDisguised(player)) {
            Scarest.dcAPI.changePlayerDisguise(player, new Disguise(Scarest.dcAPI.newEntityID(), DisguiseType.Skeleton));
        }
    }

    public void removeSkeleton(Player player) {
        Scarest.isSkelet.remove(player);
        //MobDisguiseAPI.undisguisePlayer(player);
        if (Scarest.dcAPI.isDisguised(player) && Scarest.dcAPI.getDisguise(player).type == DisguiseType.Skeleton) {
            Scarest.dcAPI.undisguisePlayer(player);
        }
    }

    public boolean arrowHasDamage(Player player) {
        return ((Boolean) Scarest.isSkelet.get(player)).booleanValue();
    }

    public boolean isSkelet(Player player) {
        return Scarest.isSkelet.containsKey(player);
    }
}