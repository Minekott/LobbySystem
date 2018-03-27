package me.letshacks.lobby.main;

import me.letshacks.lobby.commands.build;
import me.letshacks.lobby.listener.JoinQuit;
import me.letshacks.lobby.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin
{


    public static String prefix = "§8▎ §b§lLobby §3» §7";
    public static String noperm = "§cI'm sorry, but you do not have permission to execute this command. Please contact the server administrators if you believe that this is in error§c.";


    public static ArrayList<Player> buildmodus = new ArrayList<Player>();

    public static Main instance;


    public void onEnable()
    {
        instance = this;

        try
        {
            MySQL.connect();
            MySQL.update("CREATE TABLE IF NOT EXISTS Pos(UUID varchar(64), X double, Y double, Z double, Yaw float, Pitch float);");
        }
        catch (Exception e)
        {
            Bukkit.getConsoleSender().sendMessage("§c§lFehler beim verbinden mit der MySQL Datenbank!");
            Bukkit.getConsoleSender().sendMessage("§7------------------------------------------------");
            Bukkit.getConsoleSender().sendMessage("§eBitte ueberpruefe deine MySQL Daten!");
            e.printStackTrace();
        }

        getCommand("build").setExecutor(new build());

        Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);

    }

}
