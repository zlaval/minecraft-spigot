package com.zlrx.yourcraft;

import com.zlrx.yourcraft.cmd.HealthCmd;
import com.zlrx.yourcraft.cmd.HouseCmd;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Yourcraft extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        //Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("heal").setExecutor(new HealthCmd());
        getCommand("house").setExecutor(new HouseCmd());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // event.setCancelled(true);
        // event.getPlayer().sendMessage(ChatColor.RED + "You are frozen!");
    }
}
