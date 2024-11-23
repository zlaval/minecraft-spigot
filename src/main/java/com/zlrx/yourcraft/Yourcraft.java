package com.zlrx.yourcraft;

import com.zlrx.yourcraft.cmd.HealthCmd;
import com.zlrx.yourcraft.cmd.HouseCmd;
import com.zlrx.yourcraft.cmd.WeaponCmd;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Yourcraft extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        //Bukkit.getPluginManager().registerEvents(this, this);

        WorldCreator creator = new WorldCreator("Zalaworld");
        creator.environment(World.Environment.NORMAL);
        creator.type(WorldType.FLAT);
        creator.generator("2;0;1;");
        creator.createWorld();
        Bukkit.getServer().createWorld(creator);


        getCommand("heal").setExecutor(new HealthCmd());
        getCommand("house").setExecutor(new HouseCmd());
        getCommand("weapon").setExecutor(new WeaponCmd());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // event.setCancelled(true);
        // event.getPlayer().sendMessage(ChatColor.RED + "You are frozen!");
    }
}
