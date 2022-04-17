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

import cf.speederscoders.skywarsplus.backend.Chance;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * BreakRedstoneOre Created 4/8/2022
 * By YumaHisai at 1:56 PM
 */

public class BreakRedstoneOre extends Chance implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        EntityPlayer cp = ((CraftPlayer)player).getHandle();

        if(event.getBlock().getType().equals(Material.REDSTONE_ORE)){
            event.setDropItems(false); // Clear Default Drops
            event.setExpToDrop(0); // Remove XP Drop

            if(cp.getAbsorptionHearts() == 11){
                cp.setAbsorptionHearts(cp.getAbsorptionHearts() - 1);
            }

            if(cp.getAbsorptionHearts() < 10){

                cp.setAbsorptionHearts(cp.getAbsorptionHearts() + 2);

                sounds.getGHeart(player); // Play Custom Sound
            } else {
                sounds.fullGHeart(player);

            }
        }
    }
}
