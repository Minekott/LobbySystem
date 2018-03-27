package me.letshacks.lobby.commands;

import me.letshacks.lobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class build implements CommandExecutor
{


    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
    {

        if(cmd.getName().equalsIgnoreCase("build"))
        {
            if(sender instanceof Player)
            {

                Player p = (Player)sender;

                if(p.hasPermission("lobby.build"))
                {

                    if(Main.buildmodus.contains(p))
                    {
                        p.sendMessage(Main.prefix + "§7Du hast den §bBuildmodus §7verlassen.");
                        Main.buildmodus.remove(p);
                    }
                    else
                    {
                        Main.buildmodus.add(p);
                        p.sendMessage(Main.prefix + "§7Du hast den §bBuildmodus §7betreten.");
                    }

                }
                else
                {
                    p.sendMessage(Main.noperm);
                }

            }
            else
            {
                Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cDu musst ein Spieler sein!");
            }
        }
        return false;
    }
}
