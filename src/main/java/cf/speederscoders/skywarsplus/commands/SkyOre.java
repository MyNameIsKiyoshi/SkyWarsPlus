/*
 * Copyright (c) 2022. YumaHisai
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cf.speederscoders.skywarsplus.commands;

import cf.speederscoders.skywarsplus.backend.UTILS;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * SkyOre Created 4/12/2022
 * By YumaHisai at 1:04 PM
 */

@SuppressWarnings("ConstantConditions")
public class SkyOre extends UTILS implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player)){
            if(messages.lang().equals("IT")){
                sender.sendMessage(messages.CommandBlockedInConsoleIT());
            } else if(messages.lang().equals("EN")) {
                sender.sendMessage(messages.CommandBlockedInConsoleEN());
            }
            return true;
        }

        if(player.hasPermission("skywarsplus.command.oregui")){
            Inventory inv = Bukkit.createInventory(null, 36, format.color("&9&l       - GUI  ORE -"));
            for (int i = 0; i < inv.getSize(); i++) {
                if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
                    inv.setItem(i, stack.getSpacer(player));
                }
            }

            inv.setItem(10, stack.getIronOre(player, 1));

            inv.setItem(12, stack.getGoldOre(player, 1));

            inv.setItem(14, stack.getLapisOre(player, 1));

            inv.setItem(16, stack.getRedstoneOre(player, 1));

            inv.setItem(20, stack.getDiamondOre(player, 1));

            inv.setItem(24, stack.getEmeraldOre(player, 1));

            inv.setItem(31, stack.getCoralBlock(player, 1));

            sounds.openGuiOre(player);
            player.openInventory(inv);
        } else {
            player.sendMessage(format.color("&cMissing permission, if you believe you have permission to execute this command contact an administrator or contact Developer [Yuma (ユ マ) # 5369]"));
            Bukkit.getLogger().warning("&cMissing permission, if you believe you have permission to execute this command contact an administrator or contact Developer [Yuma (ユ マ) # 5369]");
            sounds.missingPerm(player);
        }

        return false;
    }
}
