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

package cf.speederscoders.skywarsplus.events;

import cf.speederscoders.skywarsplus.backend.UTILS;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

/**
 * BreakIronOre Created 4/7/2022
 * By YumaHisai at 10:53 PM
 */

public class BreakIronOre extends UTILS implements Listener{

    @EventHandler
    public void onBreak(BlockBreakEvent event){

        Player player = event.getPlayer();

        if(event.getBlock().getType().equals(Material.IRON_ORE)){
            event.setDropItems(false); // Clear Default Drops
            event.setExpToDrop(0); // Remove XP Drop

            if(getChance() <= 100 && getChance() >= 80){ // get Chain Chestplate ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(),stack.getChainChestplate(player));
            } else if(getChance() <= 40 && getChance() >= 38){ // get Stone Sword ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(),stack.getStoneSword(player));
            } else if(getChance() <= 20 && getChance() >= 18){ // get Iron Boots ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(),stack.getIronBoots(player));
            } else if(getChance() <= 16 && getChance() >= 12){ // get Arrows ✅
                Random arrowRand = new Random();
                int arrowChance = arrowRand.nextInt(2);
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(),stack.getArrow(player,  arrowChance));
            } else if(getChance() <= 12 && getChance() >= 8){ // get Chain Leggings ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(),stack.getChainLeggings(player));
            }
            //player.sendMessage(String.valueOf(getChance()));
        }

    }

}
