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

package cf.speederscoders.skywarsplus.api;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Stack Created 4/11/2022
 * By YumaHisai at 1:30 PM
 */

@SuppressWarnings({"ConstantConditions", "unused", "deprecation"})
public class Stack {

    Format format = new Format();

    /**
     * Start Iron Ore Items
     */

    public ItemStack getChainChestplate(Player player) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Chainmail Chestplate"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getStoneSword(Player player) {
        ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Stone Sword"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getIronBoots(Player player) {
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Iron Boots"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getArrow(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.ARROW, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Normal Arrow"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getChainLeggings(Player player) {
        ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Chain Leggings"));
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Start Emerald Ore Items
     */

    public ItemStack getDiamondChestplate(Player player) {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&bDiamond Chestplate"));
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, false);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getDiamondSword(Player player) {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&bDiamond Sword"));
        meta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getDiamondHelmet(Player player) {
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&bDiamond Helmet"));
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 1, false);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getKBoomBox(Player player) {
        ItemStack item = new ItemStack(Material.TNT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&cKBoom Box"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getDiamondPickaxe(Player player) {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&bDiamond Pickaxe"));
        meta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Start Diamond Ore Items
     */

    public ItemStack getIronChestplate(Player player) {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Iron Chestplate"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getIronLeggings(Player player) {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Iron Leggings"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getKnockFish(Player player) {
        ItemStack item = new ItemStack(Material.TROPICAL_FISH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.hex(113, 86, 163, format.color("&lKnock Fish")));
        meta.addEnchant(Enchantment.KNOCKBACK, 2, false);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getGApple(Player player) {
        ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&eGApple"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getIronShover(Player player) {
        ItemStack item = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Iron Shovel"));
        meta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Start Gold Ore Items
     */

    public ItemStack getBow(Player player) {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&9Bow"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getSnowBall(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.SNOWBALL, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&fSnow Ball"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getFireCharge(Player player) {
        ItemStack item = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&cFire Charge"));
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Start Inventory Items
     */

    public ItemStack getDiamondOre(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.DIAMOND_ORE, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&bDiamond ORE"));
        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getEmeraldOre(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.EMERALD_ORE, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&aEmerald ORE"));
        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getRedstoneOre(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.REDSTONE_ORE, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&cRedStone ORE"));
        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getIronOre(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.IRON_ORE, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&7Iron ORE"));
        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getLapisOre(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.LAPIS_ORE, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&9Lapis ORE"));
        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getGoldOre(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.GOLD_ORE, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&eGold ORE"));
        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getCoralBlock(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.DEAD_BRAIN_CORAL_BLOCK, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&8Dead Coral"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getHealSpell(Player player, Integer amount) {
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&d♥ Heal Spell ♥"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getSpacer(Player player) {
        ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&r"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getPlayerHead(Player player, String text) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta head_meta = (SkullMeta) head.getItemMeta();
        head_meta.setOwner(player.getPlayer().getName());
        head_meta.setDisplayName(format.color(text));
        head.setItemMeta(head_meta);
        return head;
    }

}
