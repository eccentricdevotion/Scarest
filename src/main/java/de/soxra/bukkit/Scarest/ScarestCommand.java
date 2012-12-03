package de.soxra.bukkit.Scarest;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScarestCommand implements CommandExecutor {

    private Scarest plugin;
    private CreeperUtils cu = new CreeperUtils();
    private IrongolemUtils iu = new IrongolemUtils();
    private ZombieUtils zu = new ZombieUtils();
    private LangUtils lu = new LangUtils();
    private GhastUtils gu = new GhastUtils();
    private SkeletonUtils su = new SkeletonUtils();

    public ScarestCommand(Scarest plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((label.equalsIgnoreCase("scarest")) || (label.equalsIgnoreCase("sc"))) {
            Player player = null;
            if ((sender instanceof Player)) {
                player = (Player) sender;
            }

            if (args.length == 0) {
                if (!plugin.hasRight(player, "Scarest.Help")) {
                    lu.sendError(player, "You have not enough permissions");
                    return true;
                }
                lu.sendHelp1(player);
                return true;
            }

            if (args[0].equalsIgnoreCase("off")) {
                if (!plugin.hasRight(player, "Scarest.Off")) {
                    lu.sendError(player, "You have not enough permissions");
                    return true;
                }

                if (cu.isCreeper(player)) {
                    cu.removeCreeper(player);
                    lu.sendMessage(player, "You are a normal player again.");
                    return true;
                }
                if (zu.isZombie(player)) {
                    zu.removeZombie(player);
                    lu.sendMessage(player, "You are a normal player again.");
                    return true;
                }
                if (gu.isGhast(player)) {
                    gu.removeGhast(player);
                    lu.sendMessage(player, "You are a normal player again.");
                    return true;
                }
                if (iu.isGolem(player)) {
                    iu.removeGolem(player);
                    lu.sendMessage(player, "You are a normal player again.");
                    return true;
                }
                if (su.isSkelet(player)) {
                    su.removeSkeleton(player);
                    lu.sendMessage(player, "You are a normal player again.");
                    return true;
                }
            }

            if ((args[0].equalsIgnoreCase("help")) && (args.length >= 1)) {
                if (!plugin.hasRight(player, "Scarest.Help")) {
                    lu.sendError(player, "You have not enough permissions");
                    return true;
                }
                if (args[1].equalsIgnoreCase("2")) {
                    lu.sendHelp2(player);
                    return true;
                }
                if (args[1].equalsIgnoreCase("zombie")) {
                    lu.sendHelpZombie(player);
                    return true;
                }
                if (args[1].equalsIgnoreCase("creeper")) {
                    lu.sendHelpCreeper(player);
                    return true;
                }
                if ((args[1].equalsIgnoreCase("golem")) || (args[1].equalsIgnoreCase("irongolem"))) {
                    lu.sendHelpGolem(player);
                    return true;
                }
                if (args[1].equalsIgnoreCase("skeleton")) {
                    lu.sendHelpSkeleton(player);
                    return true;
                }
                if (args[1].equalsIgnoreCase("ghast")) {
                    lu.sendHelpGhast(player);
                    return true;
                }
            }

            if ((args[0].equalsIgnoreCase("creeper")) && (args.length > 1)) {
                if ((args[1].equalsIgnoreCase("false")) && (args.length == 2)) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Creeper.Normal")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        cu.addCreeper(player, Boolean.valueOf(false));
                        lu.sendMessage(player, "Transformed as creeper without blockdamage.");
                    } else {
                        lu.sendError(player, "You are already transformed.");
                        player.sendMessage(ChatColor.RED + "Format: /scarest off");
                        return true;
                    }
                }

                if ((args[1].equalsIgnoreCase("true")) && (args.length == 3)) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Creeper.Damage")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        cu.addCreeper(player, Boolean.valueOf(true));
                        cu.addRaduis(player, Integer.valueOf(args[2]));
                        lu.sendMessage(player, "Transformed as creeper with blockdamage and a radius of " + args[2]);
                        return true;
                    }
                    lu.sendError(player, "You are already transformed.");
                    player.sendMessage(ChatColor.RED + "Format: /scarest off");
                    return true;
                }

                if ((args[1].equalsIgnoreCase("true")) && (args.length == 2)) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Creeper.Damage")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        cu.addCreeper(player, Boolean.valueOf(true));
                        cu.addRaduis(player, Integer.valueOf(4));
                        lu.sendMessage(player, "Transformed as creeper with blockdamage and the default radius.");
                        return true;
                    }
                    lu.sendError(player, "You are already transformed.");
                    player.sendMessage(ChatColor.RED + "Format: /scarest off");
                    return true;
                }
            }

            if ((args[0].equalsIgnoreCase("zombie")) && (args.length == 2)) {
                if (args[1].equalsIgnoreCase("false")) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Zombie.Normal")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        zu.addZombie(player, Boolean.valueOf(false));
                        lu.sendMessage(player, "Transformed as zombie without blockdamage");
                        return true;
                    }
                    lu.sendError(player, "You are already transformed.");
                    player.sendMessage(ChatColor.RED + "Format: /scarest off");
                    return true;
                }

                if (args[1].equalsIgnoreCase("true")) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Zombie.Damage")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        zu.addZombie(player, Boolean.valueOf(true));
                        lu.sendMessage(player, "Transformed as zombie with blockdamage");
                        return true;
                    }
                    lu.sendError(player, "You are already transformed.");
                    player.sendMessage(ChatColor.RED + "Format: /scarest off");
                    return true;
                }
            }

            if ((args[0].equalsIgnoreCase("irongolem")) && (args.length == 2)) {
                if ((args[1].equalsIgnoreCase("false"))
                        && (!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                    if (!plugin.hasRight(player, "Scarest.Mob.Golem.Normal")) {
                        lu.sendError(player, "You have not enough permissions");
                        return true;
                    }
                    iu.addGolem(player, Boolean.valueOf(false));
                    lu.sendMessage(player, "Transformed as golem without player damage");
                    return true;
                }

                if (args[1].equalsIgnoreCase("true")) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Golem.Damage")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        iu.addGolem(player, Boolean.valueOf(true));
                        lu.sendMessage(player, "Transformed as golem with player damage.");
                        return true;
                    }
                    lu.sendError(player, "You are already transformed.");
                    player.sendMessage(ChatColor.RED + "Format: /scarest off");
                    return true;
                }
            }

            if ((args[0].equalsIgnoreCase("ghast")) && (args.length == 2)) {
                if ((args[1].equalsIgnoreCase("false"))
                        && (!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                    if (!plugin.hasRight(player, "Scarest.Mob.Ghast.Normal")) {
                        lu.sendError(player, "You have not enough permissions");
                        return true;
                    }
                    gu.addGhast(player, Boolean.valueOf(false));
                    lu.sendMessage(player, "Transformed as ghast without player damage");
                    return true;
                }

                if (args[1].equalsIgnoreCase("true")) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Ghast.Damage")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        gu.addGhast(player, Boolean.valueOf(true));
                        lu.sendMessage(player, "Transformed as ghast with player damage.");
                        return true;
                    }
                    lu.sendError(player, "You are already transformed.");
                    player.sendMessage(ChatColor.RED + "Format: /scarest off");
                    return true;
                }

            }

            if ((args[0].equalsIgnoreCase("skeleton")) && (args.length == 2)) {
                if (args[1].equalsIgnoreCase("false")) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Skeleton.Normal")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        su.addSkeleton(player, Boolean.valueOf(false));
                        lu.sendMessage(player, "Transformed as skeleton without player damage.");
                        return true;
                    }
                    lu.sendError(player, "You are already transformed.");
                    player.sendMessage(ChatColor.RED + "Format: /scarest off");
                    return true;
                }

                if (args[1].equalsIgnoreCase("true")) {
                    if ((!iu.isGolem(player)) && (!zu.isZombie(player)) && (!cu.isCreeper(player))) {
                        if (!plugin.hasRight(player, "Scarest.Mob.Skelton.Damage")) {
                            lu.sendError(player, "You have not enough permissions");
                            return true;
                        }
                        su.addSkeleton(player, Boolean.valueOf(true));
                        lu.sendMessage(player, "Transformed as skeleton with player damage.");
                        return true;
                    }
                    lu.sendError(player, "You are already transformed.");
                    player.sendMessage(ChatColor.RED + "Format: /scarest off");
                    return true;
                }
            }
        }
        return false;
    }
}