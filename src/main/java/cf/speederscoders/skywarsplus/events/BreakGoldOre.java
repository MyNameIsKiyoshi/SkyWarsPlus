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

import cf.speederscoders.skywarsplus.Main;
import cf.speederscoders.skywarsplus.backend.UTILS;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

/**
 * GoldOre Created 4/7/2022
 * By YumaHisai at 10:53 PM
 */

@SuppressWarnings("ALL")
public class BreakGoldOre extends UTILS implements Listener{

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        if (event.getBlock().getType().equals(Material.GOLD_ORE)) {
            event.setDropItems(false); // Clear Default Drops

            if (getChance() <= 100 && getChance() >= 80) { // spawn T.N.T ✅
                spawnTNT(event.getBlock(), player);
            } else if (getChance() <= 40 && getChance() >= 38) { // get SnowBall ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), stack.getSnowBall(player, 16));
            } else if (getChance() <= 20 && getChance() >= 18) { // spawn T.N.T ✅
                spawnTNT(event.getBlock(), player);
            } else if (getChance() <= 16 && getChance() >= 12) { // get Bow ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), stack.getBow(player));
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), stack.getArrow(player, 3));
            } else if (getChance() <= 12 && getChance() >= 8) { // get Fire Charge ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), stack.getFireCharge(player));
            }
        }
    }

    private void spawnTNT(Block block, Player player){
        block.getWorld().createExplosion(block.getLocation(), 5, false ,false);
        List<Entity> nearby = player.getNearbyEntities(
                block.getLocation().getX(),
                block.getLocation().getY(),
                block.getLocation().getZ()
        );
        for(Entity near : nearby){
            for(int n = 0; n < 50; n++){
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                    near.getWorld().playSound(block.getLocation(), Sound.UI_BUTTON_CLICK, 50, 2);
                }, 0L);
            }
            player.damage(6);
            player.setVelocity(block.getLocation().getDirection().multiply(-1));
        }
    }

}
