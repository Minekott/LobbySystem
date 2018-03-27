package me.letshacks.lobby.utils;

import de.dytanic.cloudnet.api.CloudAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.bukkit.scoreboard.Scoreboard;

public class Scoreboard2
{

    public static void setScoreboard(Player p)
    {
        ScoreboardManager sm = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = sm.getNewScoreboard();
        int a = Methods.random(0, 999999999);
        int b = Methods.random(0, 999999999);

        scoreboard.registerNewTeam("00000Admin");
        scoreboard.registerNewTeam("00001Dev");
        scoreboard.registerNewTeam("00002Mod");
        scoreboard.registerNewTeam("00003Supp");
        scoreboard.registerNewTeam("00004Builder");
        scoreboard.registerNewTeam("00005Streamer");
        scoreboard.registerNewTeam("00006Premium");
        scoreboard.registerNewTeam("00007Spieler");

        scoreboard.getTeam("00000Admin").setPrefix("�4Admin �8| �4");
        scoreboard.getTeam("00001Dev").setPrefix("�bDev �8| �b");
        scoreboard.getTeam("00002Mod").setPrefix("�9Mod �8| �9");
        scoreboard.getTeam("00003Supp").setPrefix("�aSupp �8| �a");
        scoreboard.getTeam("00004Builder").setPrefix("�eBuilder �8| �e");
        scoreboard.getTeam("00005Streamer").setPrefix("�5Twitch �8| �5");
        scoreboard.getTeam("00006Premium").setPrefix("�6Premium �8| �6");
        scoreboard.getTeam("00007Spieler").setPrefix("�8Spieler | ");

        Team owner = scoreboard.registerNewTeam("00000owner");
        Team admin = scoreboard.registerNewTeam("00001admin");
        Team dev = scoreboard.registerNewTeam("00002dev");
        Team teamp = scoreboard.registerNewTeam("00003teamp");
        Team team = scoreboard.registerNewTeam("00004team");
        Team sup = scoreboard.registerNewTeam("00005sup");
        Team jrteam = scoreboard.registerNewTeam("00006jrteam");
        Team builder = scoreboard.registerNewTeam("00007builder");
        Team friend = scoreboard.registerNewTeam("00008friend");
        Team youtuber = scoreboard.registerNewTeam("00009youtuber");
        Team twitch = scoreboard.registerNewTeam("00010twitch");
        Team vip = scoreboard.registerNewTeam("00011vip");
        Team premium = scoreboard.registerNewTeam("00012premium");
        Team user = scoreboard.registerNewTeam("00013user");

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

        Objective o = scoreboard.registerNewObjective(Integer.toString(a), Integer.toString(b));
        o.setDisplayName("§b§l2Teams.de");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.getScore("§b§a").setScore(16);
        o.getScore("§7§lRang").setScore(15);
        o.getScore(" §8× ").setScore(14);
        o.getScore("§b ").setScore(13);
        o.getScore("§7§lCoins").setScore(12);
        try
        {
            o.getScore(" §8× §b" /*TODO: COINSAPI */).setScore(11);
        }
        catch (Exception e)
        {
            o.getScore(" §8× §b0 Coins" ).setScore(11);
        }
        o.getScore("§b§l§o§l ").setScore(10);
        o.getScore("§7§lOnline").setScore(9);
        o.getScore(" §8× §b" + CloudAPI.getInstance().getOnlineCount()).setScore(8);
        o.getScore("§c ").setScore(7);
        o.getScore("§7§lNews").setScore(6);
        o.getScore(" §8× §aRelease").setScore(4);
        o.getScore("§c§a§b§l§o§l§b§a ").setScore(1);

        String team1 = "";
        for (Player op : Bukkit.getOnlinePlayers())
        {
            if (op.hasPermission("Lobby.Admin")) {
                team1 = "00000Admin";
            } else if (op.hasPermission("Lobby.Dev")) {
                team1 = "00001Dev";
            } else if (op.hasPermission("Lobby.Mod")) {
                team1 = "00002Mod";
            } else if (op.hasPermission("Lobby.Supp")) {
                team1 = "00003Supp";
            } else if (op.hasPermission("Lobby.Builder")) {
                team1 = "00004Builder";
            } else if (op.hasPermission("Lobby.Streamer")) {
                team1 = "00005Streamer";
            } else if (op.hasPermission("Lobby.Premium")) {
                team1 = "00006Premium";
            } else {
                team1 = "00007Spieler";
            }
            scoreboard.getTeam(team1).addPlayer(op);
            p.setDisplayName(scoreboard.getTeam(team1).getPrefix() + op.getName());
        }
        p.setScoreboard(scoreboard);
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void leJoin(PlayerJoinEvent e)
    {
        for (Player a : ) {
            setScoreboard(a);
        }
    }
}
