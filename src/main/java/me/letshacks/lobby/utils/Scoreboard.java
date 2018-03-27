package me.letshacks.lobby.utils;

import de.dytanic.cloudnet.api.CloudAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Scoreboard
{
    public org.bukkit.scoreboard.Scoreboard sb;
    public Objective o;
    public static Map<UUID, Scoreboard> scoreboard = new HashMap();
    public static Map<UUID, Objective> header = new HashMap();

    public Scoreboard()
    {
        this.sb = Bukkit.getScoreboardManager().getNewScoreboard();

        this.o = this.sb.registerNewObjective("dummy", "stats");
        this.o.setDisplaySlot(DisplaySlot.SIDEBAR);
        this.o.setDisplayName("§b2Teams.de");
        this.o.getScore("    ").setScore(11);
        this.o.getScore("§7§lRang:").setScore(10);
        this.o.getScore("§7").setScore(9);
        this.o.getScore("   ").setScore(8);
        this.o.getScore("§7§lCoins").setScore(7);
        this.o.getScore("§a").setScore(6);
        this.o.getScore("  ").setScore(5);
        this.o.getScore("§7§lNews").setScore(4);
        this.o.getScore("§e").setScore(3);
        this.o.getScore(" ").setScore(2);
        this.o.getScore("§7§l").setScore(1);
        this.o.getScore("§6").setScore(0);

        Team kills = this.sb.registerNewTeam("coins");
        kills.addEntry("§a");

        Team infos = this.sb.registerNewTeam("rang");
        infos.addEntry("§7");

        Team ft = this.sb.registerNewTeam("news");
        ft.addEntry("§e");

        Team title = this.sb.registerNewTeam("title");
        title.addEntry("§b");

        Team ff = this.sb.registerNewTeam("online");
        ff.addEntry("§6");

        Team ftitle = this.sb.registerNewTeam("ftitle");
        ftitle.addEntry("§7§l");

        Team owner = this.sb.registerNewTeam("00000owner");
        Team admin = this.sb.registerNewTeam("00001admin");
        Team dev = this.sb.registerNewTeam("00002dev");
        Team teamp = this.sb.registerNewTeam("00003teamp");
        Team team = this.sb.registerNewTeam("00004team");
        Team sup = this.sb.registerNewTeam("00005sup");
        Team jrteam = this.sb.registerNewTeam("00006jrteam");
        Team builder = this.sb.registerNewTeam("00007builder");
        Team friend = this.sb.registerNewTeam("00008friend");
        Team youtuber = this.sb.registerNewTeam("00009youtuber");
        Team twitch = this.sb.registerNewTeam("00010twitch");
        Team vip = this.sb.registerNewTeam("00011vip");
        Team premium = this.sb.registerNewTeam("00012premium");
        Team user = this.sb.registerNewTeam("00013user");

        owner.setPrefix("§4§lOwner §8▪§7 ");
        admin.setPrefix("§4Admin §8⚪ §7");
        dev.setPrefix("§bDev §8⚪ §7");
        teamp.setPrefix("§cTeam+§8⚪ §7");
        team.setPrefix("§cTeam §8⚪ §7");
        sup.setPrefix("§3Sup §8⚪ §7");
        jrteam.setPrefix("§9JrTeam §8⚪ §7");
        builder.setPrefix("§2Builder §8⚪ §7");
        friend.setPrefix("§aFriend §8⚪ §7");
        youtuber.setPrefix("§5YT §8⚪ §7");
        twitch.setPrefix("§5Twitch §8⚪ §7");
        vip.setPrefix("§eVIP §8⚪ §7");
        premium.setPrefix(ChatColor.GOLD + "Premium " + ChatColor.DARK_GRAY +"⚪ " + ChatColor.GRAY);
        user.setPrefix("§7User §8⚪ §7");
    }

    public void sendToPlayer(Player p)
    {
        this.sb.getTeam("online").setSuffix(" §8×§b " + CloudAPI.getInstance().getOnlineCount());
        this.sb.getTeam("ftitle").setSuffix("§7§lOnline:");
        this.sb.getTeam("news").setSuffix(" §8× §aRelease");
        this.sb.getTeam("title").setSuffix("§7§lTeamspeak:");

        this.sb.getTeam("coins").setSuffix(" §8× " /*TODO: COINSAPI*/);
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (player.hasPermission("2teams.admin")) {
                this.sb.getTeam("00001admin").addEntry(player.getName());
            }else if (player.hasPermission("2teams.admin")) {
                this.sb.getTeam("00002dev").addEntry(player.getName());
            } else if (player.hasPermission("2teams.dev")) {
                this.sb.getTeam("00003team+").addEntry(player.getName());
            } else if (player.hasPermission("2teams.teamp")) {
                this.sb.getTeam("00004team").addEntry(player.getName());
            } else if (player.hasPermission("2teams.team")) {
                this.sb.getTeam("00005sup").addEntry(player.getName());
            } else if (player.hasPermission("2teams.sup")) {
                this.sb.getTeam("00006jrteam").addEntry(player.getName());
            } else if (player.hasPermission("2teams.jrteam")) {
                this.sb.getTeam("00007builder").addEntry(player.getName());
            } else if (player.hasPermission("2teams.builder")) {
                this.sb.getTeam("00008friend").addEntry(player.getName());
            } else if (player.hasPermission("2teams.sup")) {
                this.sb.getTeam("00009youtuber").addEntry(player.getName());
            } else if (player.hasPermission("2teams.yt")) {
                this.sb.getTeam("00010twitch").addEntry(player.getName());
            } else if (player.hasPermission("2teams.vip")) {
                this.sb.getTeam("00011vip").addEntry(player.getName());
            } else if (player.hasPermission("2teams.premium")) {
                this.sb.getTeam("00012premium").addEntry(player.getName());
            } else {
                this.sb.getTeam("00013user").addEntry(player.getName());
            }
            p.setScoreboard(this.sb);
            scoreboard.put(p.getUniqueId(), this);
            header.put(p.getUniqueId(), this.o);
        }
    }

    public static void setScoreboard(Player pl)
    {
         if (pl.hasPermission("2teams.admin"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00001admin").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.dev"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00002dev").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.teamp"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00003teamp").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.team"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00004team").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.sup"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00005sup").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.jrteam"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00006jrteam").addEntry(pl.getName());
            }
            pl.setPlayerListName("§2SrBuilder §8●§7 " + pl.getName());
        }
        else if (pl.hasPermission("2teams.builder"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00007builder").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.friend"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00008friend").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.youtuber"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00009youtuber").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.twitch"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00010twitch").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.vip"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00011vip").addEntry(pl.getName());
            }
        }
        else if (pl.hasPermission("2teams.premium"))
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00012premium").addEntry(pl.getName());
            }
        }
        else
        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ((Scoreboard)scoreboard.get(p.getUniqueId())).sb.getTeam("00013user").addEntry(pl.getName());
            }
        }
    }
}
