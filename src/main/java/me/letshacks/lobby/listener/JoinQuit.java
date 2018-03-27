package me.letshacks.lobby.listener;

import me.letshacks.lobby.main.Main;
import me.letshacks.lobby.utils.Methods;
import me.letshacks.lobby.utils.Scoreboard;
import me.letshacks.lobby.utils.getItems;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Score;

public class JoinQuit implements Listener
{

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        e.setJoinMessage(null);

        final Player p = e.getPlayer();

        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage(Main.prefix + "§7Willkommen auf §b2Teams.de§7!");
        p.sendMessage(" ");
        p.sendMessage(" ");

        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 0.3F);

        getItems.getLobbyItems(p);

        Scoreboard.setScoreboard(p);

        new Scoreboard().sendToPlayer(p);

        Location loc = p.getLocation();


        double x = Main.instance.getConfig().getDouble("Locations.Spawn.X");
        double y = Main.instance.getConfig().getDouble("Locations.Spawn.Y");
        double z = Main.instance.getConfig().getDouble("Locations.Spawn.Z");
        double yaw = Main.instance.getConfig().getDouble("Locations.Spawn.Yaw");
        double pitch = Main.instance.getConfig().getDouble("Locations.Spawn.Pitch");
        String world = Main.instance.getConfig().getString("Locations.Spawn.World");

        loc.add(x,y,z);
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);
        loc.setWorld(Bukkit.getWorld(world));


        try {
            Thread.sleep(200);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        p.teleport(loc);

        if (Methods.playerExists(e.getPlayer().getUniqueId().toString()))
        {


            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
            {
                public void run()
                {
                    Methods.tpPlayer(p);

                }
            }, 20L);
        }
        else
        {
            Methods.createPlayer(e.getPlayer().getUniqueId().toString());
        }


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        e.setQuitMessage(null);
        Methods.setPos(e.getPlayer());
    }
}
