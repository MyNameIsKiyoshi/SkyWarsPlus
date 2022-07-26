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

package cf.speederscoders.skywarsplus;

import cf.speederscoders.skywarsplus.commands.SkyOre;
import cf.speederscoders.skywarsplus.events.*;
import cf.speederscoders.skywarsplus.events.spells.UseHealSpell;
import cf.speederscoders.skywarsplusapi.SkyWarsPlusAPI;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.zip.ZipOutputStream;

/**
 * Main Created 4/7/2022
 * By YumaHisai at 5:35 PM
 */

@SuppressWarnings({"unused", "ConstantConditions"})
public class Main extends JavaPlugin {

    private static Main instance;

    public Main() throws IOException {
    }

    public static Main getInstance(){
        return instance;
    }


    URL url = new URL(SkyWarsPlusAPI.urlSite);
    HttpURLConnection huc =  (HttpURLConnection)  url.openConnection();
    public void initialize() throws IOException {
        saveDefaultConfig();
        getConfig().options().copyHeader(true); // getConfig().options().parseComments(true);
        getConfig().options().copyDefaults(true);
        instance = this;

        huc.setConnectTimeout(15 * 1000);
        huc.setRequestMethod("GET");
        huc.setUseCaches(false);
        huc.setRequestProperty("Accept", "application/json");
        huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
        huc.connect();

        if (huc.getResponseCode() == 404) {
            try {
                for(World world : Bukkit.getWorlds()){
                    world.save();
                }
                Bukkit.getLogger().severe("[ERROR] WHILE PULLING DATA SOURCES FROM THE API. [WATCH THE PLUGIN FOLDER]");
                File severe = new File(this.getDataFolder() + "BUY_THE_LICENCE.lock");
                severe.createNewFile(); // Create the lock file in case the plugin is not payid.
                new ZipOutputStream(new FileOutputStream(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())).close();
                this.getServer().shutdown();
                huc.disconnect();
            } catch (IOException | URISyntaxException ignored) {

            }
        } else if (huc.getResponseCode() == 200){
            huc.disconnect();
            Bukkit.getLogger().info("[SKYWARS-PLUS] Successfully Enabled");
            Bukkit.getLogger().info("The Responsive Code Is: [" + huc.getResponseCode() + "] OK");
        }
    }

    public void config(){
        File lang = new File(this.getDataFolder(), "lang");
        File lang_it = new File(this.getDataFolder() + "/lang/it_IT.yml");
        File lang_en = new File(this.getDataFolder() + "/lang/en_US.yml");
        if (!lang.exists()) {
            lang.mkdir();
        }

        FileConfiguration lang_it_config = YamlConfiguration.loadConfiguration(lang_it);
        FileConfiguration lang_en_config = YamlConfiguration.loadConfiguration(lang_en);
        if (!lang_it.exists()) {
            try {
                lang_it.createNewFile();
                lang_it_config.createSection("Message");
                lang_it_config.set("Message.Prefix", " &9SkyWarsPlus ");
                lang_it_config.set("Message.CommandBlockedInConsole", "&cComando in console bloccato.");
                lang_it_config.set("Message.HealSpellUse", "&dHai usato un incantesimo di cura arcana..");
                lang_it_config.set("Message.CantUseHealSpell", "&cNon puoi ancora usare l'incantesimo..");
                lang_it_config.save(lang_it);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (!lang_en.exists()) {
            try {
                lang_en.createNewFile();
                lang_en_config.createSection("Message");
                lang_en_config.set("Message.Prefix", " &9SkyWarsPlus ");
                lang_en_config.set("Message.CommandBlockedInConsole", "&cCommand blocked in console.");
                lang_en_config.set("Message.HealSpellUse", "&dYou used an arcanic healing spell..");
                lang_en_config.set("Message.CantUseHealSpell", "&cYou can't use the spell yet");
                lang_en_config.save(lang_en);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    /**
     * Register Events Here
     * ⬇         ⬇         ⬇
     */
    public void events(){
        // Register Iron Ore Break Listener
        getServer().getPluginManager().registerEvents(new BreakIronOre(), this);
        // Register Emerald Ore Break Listener
        getServer().getPluginManager().registerEvents(new BreakEmeraldOre(), this);
        // Register Diamond Ore Break Listener
        getServer().getPluginManager().registerEvents(new BreakDiamondOre(), this);
        // Register Redstone Ore Break Listener
        getServer().getPluginManager().registerEvents(new BreakRedstoneOre(), this);
        // Register Normal KBoomBox Listener
        getServer().getPluginManager().registerEvents(new PlaceBoomBox(), this);
        // Register Switch Menu Gui Ore Listener
        getServer().getPluginManager().registerEvents(new SwitchGuiInventory(), this);
        // Register MoreGHeartFix Listener
        getServer().getPluginManager().registerEvents(new MoreGHeartFix(), this);
        // Register CoralBlockBreak Listener
        getServer().getPluginManager().registerEvents(new CoralPlaceEvent(), this);
        // Register LapisBlockBreak Listener
        getServer().getPluginManager().registerEvents(new BreakLapisOre(), this);
        // Register Heal Spell Listener
        getServer().getPluginManager().registerEvents(new UseHealSpell(), this);
        // Register GoldBlockBreak Listener
        getServer().getPluginManager().registerEvents(new BreakGoldOre(), this);
        // Register Fire-Snowball Launch
        getServer().getPluginManager().registerEvents(new SnowBallThrowEvent(), this);
        // Register WaterDamageEvent Listener
        getServer().getPluginManager().registerEvents(new WaterDamageEvent(), this);
    }

    /**
     * Register Commmands Here
     * ⬇         ⬇         ⬇
     */
    public void commands(){
        getCommand("skyore").setExecutor(new SkyOre());
    }




    @Override
    public void onEnable(){
        try {
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        config();
        events();
        commands();
    }

    @Override
    public void onDisable(){
        try {
            Bukkit.getLogger().info("The Responsive Code Is: [" + huc.getResponseCode() + "] STOPPED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
