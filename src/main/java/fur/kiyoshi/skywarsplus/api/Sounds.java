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

package fur.kiyoshi.skywarsplus.api;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Sounds Created 4/11/2022
 * By MyNameIsKiyoshi at 12:22 PM
 */

@SuppressWarnings("unused")
public class Sounds {

    public void getSpell(Player p){
        p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_DRINK, 50, 2);
        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 50, 2);
    }

    public void failSpell(Player p){
        p.playSound(p.getLocation(), Sound.ITEM_SHIELD_BLOCK, 50, 2);
    }

    public void getGHeart(Player p){
        p.playSound(p.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 50, 2);
        p.playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 50, 2);
    }

    public void fullGHeart(Player p){
        p.playSound(p.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_AMBIENT, 50, 2);
        p.playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 50, 2);
    }

    public void emeraldBreak(Player p){
        p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_2, 50, 2);
        p.playSound(p.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 50, 2);
    }

    public void missingPerm(Player p){
        p.playSound(p.getLocation(), Sound.BLOCK_CONDUIT_DEACTIVATE, 50, 2);
        p.playSound(p.getLocation(), Sound.ENTITY_WOLF_GROWL, 50, 2);
    }

    public void openGuiOre(Player p){
        p.playSound(p.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 50, 2);
        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 50, 2);
    }

    public void getItemFromGuiOre(Player p){
        p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_RETURN, 50, 2);
        p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE_FAR, 50, 2);
    }

    public void zzz(Player p){
        p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 50, 2);
    }

    public void explodeBlock(Player p){
        p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 50, 2);
        p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE_FAR, 50, 2);
    }

    public void useHealSpell(Player p){
        p.playSound(p.getLocation(), Sound.ITEM_TOTEM_USE, 50, 2);
        p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE_FAR, 50, 2);
    }

    public void cantUseHealSpell(Player p){
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 50, 2);
        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 50, 2);
    }

}
