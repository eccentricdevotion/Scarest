package de.soxra.bukkit.Scarest;

import org.bukkit.entity.Player;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

public class ZombieUtils {

    public boolean isZombie(Player player) {
        return Scarest.isZombie.containsKey(player);
    }

    public boolean canChew(Player player) {
        return ((Boolean) Scarest.isZombie.get(player)).booleanValue();
    }

    public void addZombie(Player player, Boolean bool) {
        Scarest.isZombie.put(player, bool);
        //MobDisguiseAPI.disguisePlayer(player, "zombie");
        if (!Scarest.dcAPI.isDisguised(player)) {
            Scarest.dcAPI.changePlayerDisguise(player, new Disguise(Scarest.dcAPI.newEntityID(), DisguiseType.Zombie));
        }
    }

    public void removeZombie(Player player) {
        Scarest.isZombie.remove(player);
        //MobDisguiseAPI.undisguisePlayer(player);
        if (Scarest.dcAPI.isDisguised(player) && Scarest.dcAPI.getDisguise(player).type == DisguiseType.Zombie) {
            Scarest.dcAPI.undisguisePlayer(player);
        }
    }

    public boolean isActive(Player player) {
        return Scarest.isActiv.contains(player);
    }

    public void addActive(Player player) {
        Scarest.isActiv.add(player);
    }

    public void removeActive(Player player) {
        Scarest.isActiv.remove(player);
    }
}