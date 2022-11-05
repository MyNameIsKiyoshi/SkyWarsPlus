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

import fur.kiyoshi.skywarsplus.Main;
import fur.kiyoshi.skywarsplus.backend.UTILS;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * CoralPlaceEvent Created 4/16/2022
 * By MyNameIsKiyoshi at 5:57 PM
 */

public class CoralPlaceEvent extends UTILS implements Listener {



    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        Block block = event.getBlock();
        Material material = block.getType();
        Player player = event.getPlayer();
        int id = (int) System.currentTimeMillis();


        if(material.equals(Material.DEAD_BRAIN_CORAL_BLOCK)){

        	// Il Server non c'entra il coral e' inteso come BLOCCO!!!!!!!

            PacketPlayOutBlockBreakAnimation packet1 = new PacketPlayOutBlockBreakAnimation(id, new BlockPosition(block.getX(), block.getY(), block.getZ()), 3);
            PacketPlayOutBlockBreakAnimation packet2 = new PacketPlayOutBlockBreakAnimation(id, new BlockPosition(block.getX(), block.getY(), block.getZ()), 6);
            PacketPlayOutBlockBreakAnimation packet3 = new PacketPlayOutBlockBreakAnimation(id, new BlockPosition(block.getX(), block.getY(), block.getZ()), 9);
            PacketPlayOutBlockBreakAnimation packet0 = new PacketPlayOutBlockBreakAnimation(id, new BlockPosition(block.getX(), block.getY(), block.getZ()), -1);
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> ((CraftPlayer) player).getHandle().b.a(packet1), 20L);
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> ((CraftPlayer) player).getHandle().b.a(packet2), 40L);
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                ((CraftPlayer) player).getHandle().b.a(packet3);
                ((CraftPlayer) player).getHandle().b.a(packet0);
                block.setType(Material.AIR);
            }, 60L);
        }
    }
}
