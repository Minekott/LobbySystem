package me.letshacks.lobby.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class getItems
{

    public static void getLobbyItems(Player p)
    {
        p.getInventory().clear();

        if (p.hasPermission("system.team"))
        {
            p.getInventory().setItem(0, Items.createItem(Material.COMPASS, 1 ,0, "§bNavigator §8× §7Rechtsklick"));
            p.getInventory().setItem(1, Items.getHead(p, "§bFreunde §8× §7Rechtsklick"));
            p.getInventory().setItem(3, Items.createItem(Material.NAME_TAG, 1 ,0, "§bNick §8× §7Rechtsklick"));
            p.getInventory().setItem(4, Items.createItem(Material.CHEST, 1, 0, "§bExtras §8× §7Rechtsklick"));
            p.getInventory().setItem(5, Items.createItem(Material.NETHER_STAR, 1, 0, "§bTeam §8× §7Rechtsklick"));
            p.getInventory().setItem(7, Items.createItem(Material.REDSTONE_COMPARATOR, 1 ,0, "§bEinstellungen §8× §7Rechtsklick"));
            p.getInventory().setItem(8, Items.createItem(Material.BEACON, 1, 0, "§bLobbies §8× §7Rechtsklick"));


        }
        else if (p.hasPermission("system.yt"))
        {

            p.getInventory().setItem(0, Items.createItem(Material.COMPASS, 1 ,0, "§bNavigator §8× §7Rechtsklick "));
            p.getInventory().setItem(1, Items.getHead(p, "§bFreunde §8× §7Rechtsklick"));
            p.getInventory().setItem(3, Items.createItem(Material.NAME_TAG, 1 ,0, "§bNick §8× §7Rechtsklick"));
            p.getInventory().setItem(5, Items.createItem(Material.CHEST, 1, 0, "§bExtras §8× §7Rechtsklick"));
            p.getInventory().setItem(7, Items.createItem(Material.REDSTONE_COMPARATOR, 1 ,0, "§bEinstellungen §8× §7Rechtsklick"));
            p.getInventory().setItem(8, Items.createItem(Material.BEACON, 1, 0, "§bLobbies §8× §7Rechtsklick"));

        }
        else
        {

            p.getInventory().setItem(0, Items.createItem(Material.COMPASS, 1 ,0, "§bNavigator §8× §7Rechtsklick "));
            p.getInventory().setItem(1, Items.getHead(p, "§bFreunde §8× §7Rechtsklick"));
            p.getInventory().setItem(4, Items.createItem(Material.CHEST, 1, 0, "§bExtras §8× §7Rechtsklick"));
            p.getInventory().setItem(7, Items.createItem(Material.REDSTONE_COMPARATOR, 1 ,0, "§bEinstellungen §8× §7Rechtsklick"));
            p.getInventory().setItem(8, Items.createItem(Material.BEACON, 1, 0, "§bLobbies §8× §7Rechtsklick"));

        }
    }
}
