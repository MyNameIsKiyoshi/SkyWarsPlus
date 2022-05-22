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
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * PlaceBoomBox Created 4/8/2022
 * By YumaHisai at 4:50 PM
 */

@SuppressWarnings("ALL")
public class PlaceBoomBox extends UTILS implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event){

        Player player = event.getPlayer();

        int posx = event.getBlock().getLocation().getBlockX();
        int posy = event.getBlock().getLocation().getBlockY();
        int posz = event.getBlock().getLocation().getBlockZ();
        Location blockSpawnLoc = new Location(
                event.getBlock().getWorld(),
                posx, posy + 1, posz
        );

        if(player.getInventory().getItemInHand().equals(stack.getKBoomBox(player))){
            event.getBlock().setType(Material.AIR);
            event.getBlock().getLocation().getWorld().spawnEntity(
                    blockSpawnLoc,
                    EntityType.PRIMED_TNT
            );
        }
    }
}
