package de.soxra.bukkit.Scarest;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LangUtils {

    public void logInfo(String info) {
        Scarest.log.info("[Scarest] " + info);
    }

    public void logWarn(String warning) {
        Scarest.log.warning("[Scarest] " + warning);
    }

    public void logSev(String sev) {
        Scarest.log.severe("[Scarest] " + sev);
    }

    public void sendMessage(Player player, String msg) {
        player.sendMessage(ChatColor.DARK_GREEN + "[Scarest] " + ChatColor.GOLD + msg);
    }

    public void sendError(Player player, String error) {
        player.sendMessage(ChatColor.DARK_GREEN + "[Scarest] " + ChatColor.RED + error);
    }

    public void sendHelp1(Player player) {
        player.sendMessage(ChatColor.DARK_GREEN + "---------- Scarest Help Page 1 ----------");
        player.sendMessage(ChatColor.GOLD + "Commands <needed> [optional]:");
        player.sendMessage(ChatColor.GOLD + " - /scarest <mobtype> [true | false] [radius]");
        player.sendMessage(ChatColor.GOLD + " Transform into <mobtype> with block or player damage with the [radius]");
        player.sendMessage(ChatColor.GOLD + " [radius] is only aviable for mobtype creeper. (Radius of explosion)");
        player.sendMessage(ChatColor.GOLD + " [true | false] is aviable for all types. (if creepers make blockdamage, if golems can throw players, if zombie can chew doors etc.)");
        player.sendMessage(ChatColor.DARK_GREEN + " - /scarest off, be a normal player again");
        player.sendMessage(ChatColor.GOLD + " - /scarest help 2 for help page 2.");
    }

    public void sendHelp2(Player player) {
        player.sendMessage(ChatColor.DARK_GREEN + "---------- Scarest Help Page 1 ----------");
        player.sendMessage(ChatColor.GOLD + " Effects by pressed Shift (or left or right click):");
        player.sendMessage(ChatColor.GOLD + " - /scarest help creeper, creeper help");
        player.sendMessage(ChatColor.GOLD + " - /scarest help zombie, zombie help");
        player.sendMessage(ChatColor.GOLD + " - /scarest help golem, golem help");
        player.sendMessage(ChatColor.GOLD + " - /scarest help ghast, ghast help");
        player.sendMessage(ChatColor.GOLD + " - /scarest help skeleton, skeleton help");
    }

    public void sendHelpGhast(Player player) {
        player.sendMessage(ChatColor.DARK_GREEN + "---------- Scarest Ghast Help ----------");
        player.sendMessage(ChatColor.GOLD + " Effects by pressed rightclick:");
        player.sendMessage(ChatColor.GOLD + " Everywhere you leftclick will shoot a fireball.");
    }

    public void sendHelpZombie(Player player) {
        player.sendMessage(ChatColor.DARK_GREEN + "---------- Scarest Zombie Help ----------");
        player.sendMessage(ChatColor.GOLD + " Effects by pressed rightclick:");
        player.sendMessage(ChatColor.GOLD + " Stand in front of a door. You will hear zombie noises and the door in front of you will break.");
    }

    public void sendHelpSkeleton(Player player) {
        player.sendMessage(ChatColor.DARK_GREEN + "---------- Scarest Skeleton Help ----------");
        player.sendMessage(ChatColor.GOLD + " Effects by pressed right or left click:");
        player.sendMessage(ChatColor.GOLD + " Will shoot a simple arrow to your target.");
    }

    public void sendHelpGolem(Player player) {
        player.sendMessage(ChatColor.DARK_GREEN + "---------- Scarest Golem Help ----------");
        player.sendMessage(ChatColor.GOLD + " Effects by pressed Shift and left or right click:");
        player.sendMessage(ChatColor.GOLD + " Stay nearly a player and rightclick him. The player will be thrown away with damage.");
    }

    public void sendHelpCreeper(Player player) {
        player.sendMessage(ChatColor.DARK_GREEN + "---------- Scarest Creeper Help ----------");
        player.sendMessage(ChatColor.GOLD + " Effects by pressed Shift:");
        player.sendMessage(ChatColor.GOLD + " If choosen true, there will be a explosion around you with your set radius.");
        player.sendMessage(ChatColor.GOLD + " If choosen false, there will be a explosion around you without destroying blocks.");
    }
}