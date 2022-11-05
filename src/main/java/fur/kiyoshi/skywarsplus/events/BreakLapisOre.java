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
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * BreakLapisOre Created 4/7/2022
 * By MyNameIsKiyoshi at 10:53 PM
 */

@SuppressWarnings("ALL")
public class BreakLapisOre extends UTILS implements Listener{

    @EventHandler
    public void onBreak(BlockBreakEvent event){

        Player player = event.getPlayer();

        if(event.getBlock().getType().equals(Material.LAPIS_ORE)){
            event.setDropItems(false); // Clear Default Drops

            if(getChance() <= 100 && getChance() >= 80){ // get Null ✅
                sounds.failSpell(player);
            } else if(getChance() <= 40 && getChance() >= 38){ // get Spell ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(),stack.getHealSpell(player, 1));
                sounds.getSpell(player);
            } else if(getChance() <= 20 && getChance() >= 18){ // get Null ✅
                sounds.failSpell(player);
            } else if(getChance() <= 16 && getChance() >= 12){ // get Spell ✅
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(),stack.getHealSpell(player, 1));
                sounds.getSpell(player);
            } else if(getChance() <= 12 && getChance() >= 8){ // get Null ✅
                sounds.failSpell(player);
            }

            int posx = event.getBlock().getLocation().getBlockX();
            int posy = event.getBlock().getLocation().getBlockY();
            int posz = event.getBlock().getLocation().getBlockZ();
            Location blockParticleLoc = new Location(
                    event.getBlock().getWorld(),
                    posx, posy + 1, posz
            );

            event.getBlock().getLocation().getWorld().spawnParticle(
                    Particle.NOTE,
                    blockParticleLoc, 25
            );
        }

    }

}
