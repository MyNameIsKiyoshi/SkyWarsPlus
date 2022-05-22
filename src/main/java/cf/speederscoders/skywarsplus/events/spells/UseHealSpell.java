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

package cf.speederscoders.skywarsplus.events.spells;

import cf.speederscoders.skywarsplus.backend.UTILS;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * UseHealSpell Created 4/16/2022
 * By YumaHisai at 10:14 PM
 */

public class UseHealSpell extends UTILS implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent event){
        Player player = event.getPlayer();

        int posx = player.getLocation().getBlockX();
        int posy = player.getLocation().getBlockY();
        int posz = player.getLocation().getBlockZ();
        Location playerParticleLoc = new Location(
                player.getWorld(),
                posx, posy + 3, posz
        );

        if(event.getAction() == Action.RIGHT_CLICK_AIR ||
        event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(player.getInventory().getItemInHand().equals(stack.getHealSpell(player, 1))){
                if(player.getHealth() >= 20){
                    if(messages.lang().equals("IT")){
                        player.sendMessage(messages.CantUseHealSpellIT());
                    } else if(messages.lang().equals("EN")){
                        player.sendMessage(messages.CantUseHealSpellEN());
                    }
                    sounds.cantUseHealSpell(player);
                } else {
                    player.getInventory().removeItem(player.getInventory().getItemInHand());
                    player.setHealth(20);
                    if(messages.lang().equals("IT")){
                        player.sendMessage(messages.HealSpellUseIT());
                    } else if(messages.lang().equals("EN")){
                        player.sendMessage(messages.HealSpellUseEN());
                    }
                    player.getLocation().getWorld().spawnParticle(
                            Particle.HEART,
                            playerParticleLoc, 15
                    );
                    sounds.useHealSpell(player);
                }



            }
        }

    }

}
