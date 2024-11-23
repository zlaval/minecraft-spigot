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
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();
            int startX = location.getBlockX() + 1;
            int startY = location.getBlockY();
            int startZ = location.getBlockZ() + 1;
            buildHouse(player, startX, startY, startZ);
        }
        return false;
    }

    private void buildHouse(Player player, int startX, int startY, int startZ) {
        // Get the world the player is in
        var world = player.getWorld();

        // Dimensions
        int width = 10;
        int length = 10;
        int height = 6;
        int roofHeight = 3;

        // Build the walls
        for (int x = 0; x < width; x++) {
            for (int z = 0; z < length; z++) {
                for (int y = 0; y < height; y++) {
                    // Build walls only on the edges
                    if (x == 0 || x == width - 1 || z == 0 || z == length - 1) {
                        // Leave space for door and window
                        if (!((x == 0 && z == 5 && y == 1) ||  // Door position
                                (x == width - 1 && z == 3 && (y == 3 || y == 4)))) { // Window position
                            world.getBlockAt(startX + x, startY + y, startZ + z).setType(Material.BRICKS);
                        }
                    }
                }
            }
        }

        // Create a door (wooden)
        world.getBlockAt(startX, startY + 1, startZ + 5).setType(Material.OAK_DOOR);
        world.getBlockAt(startX, startY + 2, startZ + 5).setType(Material.OAK_DOOR);

        // Create a window (glass)
        world.getBlockAt(startX + width - 1, startY + 3, startZ + 3).setType(Material.GLASS);
        world.getBlockAt(startX + width - 1, startY + 4, startZ + 3).setType(Material.GLASS);

        // Build the roof (wooden planks, pyramid shape)
        for (int y = 0; y < roofHeight; y++) {
            for (int x = y; x < width - y; x++) {
                for (int z = y; z < length - y; z++) {
                    world.getBlockAt(startX + x, startY + height + y, startZ + z).setType(Material.OAK_PLANKS);
                }
            }
        }

        // Clear the interior
        for (int x = 1; x < width - 1; x++) {
            for (int z = 1; z < length - 1; z++) {
                for (int y = 1; y < height; y++) {
                    world.getBlockAt(startX + x, startY + y, startZ + z).setType(Material.AIR);
                }
            }
        }
    }
}
