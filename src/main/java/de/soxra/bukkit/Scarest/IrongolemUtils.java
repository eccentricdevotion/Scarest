package de.soxra.bukkit.Scarest;

import org.bukkit.entity.Player;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

public class IrongolemUtils {

    public boolean canHit(Player player) {
        return ((Boolean) Scarest.isGolem.get(player)).booleanValue();
    }

    public boolean isGolem(Player player) {
        return Scarest.isGolem.containsKey(player);
    }

    public void removeGolem(Player player) {
        Scarest.isGolem.remove(player);
        //MobDisguiseAPI.undisguisePlayer(player);
        if (Scarest.dcAPI.isDisguised(player) && Scarest.dcAPI.getDisguise(player).type == DisguiseType.IronGolem) {
            Scarest.dcAPI.undisguisePlayer(player);
        }
        if (Scarest.dcAPI.isDisguised(player)) {
            Scarest.dcAPI.changePlayerDisguise(player, new Disguise(Scarest.dcAPI.newEntityID(), DisguiseType.IronGolem));
        }
    }

    public void addGolem(Player player, Boolean bool) {
        Scarest.isGolem.put(player, bool);
        //MobDisguiseAPI.disguisePlayer(player, "irongolem");
        if (!Scarest.dcAPI.isDisguised(player)) {
            Scarest.dcAPI.disguisePlayer(player, new Disguise(Scarest.dcAPI.newEntityID(), DisguiseType.IronGolem));
        }
    }
}