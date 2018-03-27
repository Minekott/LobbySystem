package me.letshacks.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class StuffListener implements Listener
{

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e)
    {
        e.setFoodLevel(20);
    }


    @EventHandler
    public void onDamage(EntityDamageEvent e)
    {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDamage2(EntityDamageByEntityEvent e)
    {
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e)
    {
        e.getWorld().setThundering(false);
        e.getWorld().setStorm(false);
    }

}