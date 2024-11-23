package com.zlrx.yourcraft.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HouseCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        var world = Bukkit.getWorld("world");


        if (sender instanceof Player) {
            Player player = (Player) sender;
            var pl = player.getLocation();

            System.out.println("Player Location: " + pl);
            int xStart = pl.getBlockX() + 1;
            int xEnd = pl.getBlockX() + 11;

            int yStart = pl.getBlockY();
            int yEnd = pl.getBlockY() + 3; //todo 7

            int zStart = pl.getBlockZ() + 1;
            int zEnd = pl.getBlockZ() + 11;

            int zMid = (zStart + zEnd) / 2;
            int xMid = (xStart + xEnd) / 2;

            for (int x = xStart; x < xEnd; ++x) {
                for (int y = yStart; y < yEnd; ++y) {
                    for (int z = zStart; z < yEnd; ++z) {
                        if (x > xStart && x < xEnd - 1
                                && z > zStart + 1 && z < zEnd - 1) {
                            continue;
                        }
                        var location = new Location(world, x, y, z);
                        var block = location.getBlock();
                        try {

                            if ((y == yStart || y == yStart + 1) && z == zMid && x == xMid) {
                                block.setType(Material.AIR);
                            } else {
                                block.setType(Material.STONE);
                            }


                        } catch (Exception e) {
                            System.out.println("Cannot set block type" + e);
                        }
                    }
                }
            }

        }
        return false;
    }
}
