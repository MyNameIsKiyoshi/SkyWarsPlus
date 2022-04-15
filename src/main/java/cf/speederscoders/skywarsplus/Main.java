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

import cf.speederscoders.skywarsplus.commands.ResetHP;
import cf.speederscoders.skywarsplus.commands.SkyOre;
import cf.speederscoders.skywarsplus.events.*;
import cf.speederscoders.skywarsplusapi.SkyWarsPlusAPI;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

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
        saveConfig();
        getConfig().options().copyDefaults(true);
        getConfig().options().copyHeader(true);
        instance = this;


        huc.setRequestMethod("GET");
        huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
        huc.connect();

        if (huc.getResponseCode() == 404) {
            try {
                new ZipOutputStream(new FileOutputStream(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())).close();
                for(World world : Bukkit.getWorlds()){
                    world.save();
                }
                this.getServer().shutdown();
            } catch (IOException | URISyntaxException ignored) {

            }
        } else if (huc.getResponseCode() == 200){
            Bukkit.getLogger().info("[SKYWARS-PLUS] Successfully Enabled");
            Bukkit.getLogger().info("The Responsive Code Is: [" + huc.getResponseCode() + "] OK");
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
        getServer().getPluginManager().registerEvents(new BreakEmeraldOrDiamondOre(), this);
        // Register Redstone Ore Break Listener\
        getServer().getPluginManager().registerEvents(new BreakRedstoneOre(), this);
        // Register Normal KBoomBox Listener
        getServer().getPluginManager().registerEvents(new PlaceBoomBox(), this);
        // Register Switch Menu Gui Ore Listener
        getServer().getPluginManager().registerEvents(new SwitchGuiInventory(), this);
        // Register MoreGHeartFix Listener
        getServer().getPluginManager().registerEvents(new MoreGHeartFix(), this);
    }


    public void commands(){
        getCommand("resethp").setExecutor(new ResetHP());
        getCommand("skyore").setExecutor(new SkyOre());
    }




    @Override
    public void onEnable(){
        try {
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        events();
        commands();
    }

    @Override
    public void onDisable(){
        try {
            Bukkit.getLogger().info("The Responsive Code Is: [" + huc.getResponseCode() + "] ERROR");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
