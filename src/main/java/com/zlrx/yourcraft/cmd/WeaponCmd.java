package com.zlrx.yourcraft.cmd;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WeaponCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        var ds = new ItemStack(Material.DIAMOND_SWORD);
        var da = new ItemStack(Material.DIAMOND_AXE);
        var pa = new ItemStack(Material.DIAMOND_PICKAXE);

        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().addItem(ds);
            player.getInventory().addItem(da);
            player.getInventory().addItem(pa);
        }

        return false;
    }
}
