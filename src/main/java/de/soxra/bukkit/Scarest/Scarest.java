package de.soxra.bukkit.Scarest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import pgDev.bukkit.DisguiseCraft.DisguiseCraft;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

public class Scarest extends JavaPlugin {

    public static Logger log = Logger.getLogger("Minecraft");
    private LangUtils lu = new LangUtils();
    public static Permission permission = null;
    private ScarestCommand scarestCommand;
    public static HashMap<Player, Boolean> isCreeper = new HashMap();
    public static HashMap<Player, Integer> exRaduis = new HashMap();
    public static HashMap<Player, Boolean> isGolem = new HashMap();
    public static ArrayList<Player> sneaking = new ArrayList();
    public static HashMap<Player, Boolean> isGhast = new HashMap();
    public static HashMap<Player, Boolean> isZombie = new HashMap();
    public static ArrayList<Player> isActiv = new ArrayList();
    public static HashMap<Player, Boolean> isSkelet = new HashMap();
    private LogoutEvent le = new LogoutEvent(this);
    private CreeperExplosion ce = new CreeperExplosion(this);
    private PlayerThrow pt = new PlayerThrow(this);
    private FireballThrow ft = new FireballThrow(this);
    private ShootArrow sa = new ShootArrow(this);
    private ChewDoor cd = new ChewDoor(this);
    PluginManager pm = Bukkit.getServer().getPluginManager();
    public static DisguiseCraftAPI dcAPI;

    @Override
    public void onEnable() {
        try {
            setupDisguiseCraft();
            setupPermissions();
            registerEvents();
        } catch (Exception e) {
            lu.logSev("Error: ");
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
    }

    private void registerEvents() {

        pm.registerEvents(le, this);
        pm.registerEvents(ce, this);
        pm.registerEvents(pt, this);
        pm.registerEvents(ft, this);
        pm.registerEvents(sa, this);
        pm.registerEvents(cd, this);
        scarestCommand = new ScarestCommand(this);
        getCommand("scarest").setExecutor(scarestCommand);
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider permissionProvider = getServer().getServicesManager().getRegistration(Permission.class);
        if (permissionProvider != null) {
            permission = (Permission) permissionProvider.getProvider();
        }
        return permission != null;
    }

    public boolean hasRight(Player player, String node) {
        return (permission.has(player, node)) || (player.isOp()) || (player.hasPermission(node));
    }

    public void setupDisguiseCraft() {
        dcAPI = DisguiseCraft.getAPI();
    }
}