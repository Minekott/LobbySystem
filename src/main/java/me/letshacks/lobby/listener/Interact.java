package me.letshacks.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener
{

    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {

        Player p = e.getPlayer();

        if(e.getItem() != null)
        {
            if((e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bNavigator §8× §7Rechtsklick"))
            {

            }
        }
    }
}
