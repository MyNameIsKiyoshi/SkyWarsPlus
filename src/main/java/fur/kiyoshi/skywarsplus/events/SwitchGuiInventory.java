/*
 * Copyright (c) 2022. MyNameIsKiyoshi
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

package fur.kiyoshi.skywarsplus.events;

import fur.kiyoshi.skywarsplus.backend.UTILS;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * SwitchGuiInventory Created 4/12/2022
 * By MyNameIsKiyoshi at 1:40 PM
 */

public class SwitchGuiInventory extends UTILS implements Listener {


    @EventHandler
    @Deprecated
    public void PetsMove(InventoryClickEvent e) {

        if (e.getView().getTitle().equalsIgnoreCase(format.color("&9&l       - GUI  ORE -"))) {
            Player player = (Player) e.getWhoClicked();
            //noinspection ConstantConditions
            switch (e.getCurrentItem().getType()) {
                case GRAY_STAINED_GLASS_PANE:
                    break;
                case IRON_ORE:
                    if(e.isShiftClick()){
                        player.getInventory().addItem(stack.getIronOre(player, 64));
                    } else {
                        player.getInventory().addItem(stack.getIronOre(player, 1));
                    }
                    break;
                case GOLD_ORE:
                    if(e.isShiftClick()){
                        player.getInventory().addItem(stack.getGoldOre(player, 64));
                    } else {
                        player.getInventory().addItem(stack.getGoldOre(player, 1));
                    }
                    break;
                case LAPIS_ORE:
                    if(e.isShiftClick()){
                        player.getInventory().addItem(stack.getLapisOre(player, 64));
                    } else {
                        player.getInventory().addItem(stack.getLapisOre(player, 1));
                    }
                    break;
                case REDSTONE_ORE:
                    if(e.isShiftClick()){
                        player.getInventory().addItem(stack.getRedstoneOre(player, 64));
                    } else {
                        player.getInventory().addItem(stack.getRedstoneOre(player,1));
                    }
                    break;
                case DIAMOND_ORE:
                    if(e.isShiftClick()){
                        player.getInventory().addItem(stack.getDiamondOre(player, 64));
                    } else {
                        player.getInventory().addItem(stack.getDiamondOre(player, 1));
                    }
                    break;
                case EMERALD_ORE:
                    if(e.isShiftClick()){
                        player.getInventory().addItem(stack.getEmeraldOre(player, 64));
                    } else {
                        player.getInventory().addItem(stack.getEmeraldOre(player, 1));
                    }
                    break;
                case DEAD_BRAIN_CORAL_BLOCK:
                    if(e.isShiftClick()){
                        player.getInventory().addItem(stack.getCoralBlock(player, 64));
                    } else {
                        player.getInventory().addItem(stack.getCoralBlock(player, 1));
                    }
                    break;
            }
            sounds.getItemFromGuiOre(player);
            e.setCancelled(true);
        }
    }
}
