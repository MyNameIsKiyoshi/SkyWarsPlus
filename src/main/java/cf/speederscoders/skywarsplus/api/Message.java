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

import cf.speederscoders.skywarsplus.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Message Created 4/16/2022
 * By YumaHisai at 9:22 PM
 */

@SuppressWarnings("unused")
public class Message {
    public static File lang_it = new File(Main.getInstance().getDataFolder() + "/lang/it_IT.yml");
    public static File lang_en = new File(Main.getInstance().getDataFolder() + "/lang/en_US.yml");
    public static FileConfiguration lang_it_config;
    public static FileConfiguration lang_en_config;
    public static String lang;
    Format format = new Format();


    public String lang(){
        return Main.getInstance().getConfig().getString("Lang");
    }
    public String CommandBlockedInConsoleIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Message.CommandBlockedInConsole")) : "";
    }

    public String PrefixIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Message.Prefix")) : "";
    }

    public String HealSpellUseIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Message.HealSpellUse")) : "";
    }

    public String CantUseHealSpellIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Message.CantUseHealSpell")) : "";
    }

    public String CommandBlockedInConsoleEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Message.CommandBlockedInConsole")) : "";
    }


    public String HealSpellUseEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Message.HealSpellUse")) : "";
    }

    public String CantUseHealSpellEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Message.CantUseHealSpell")) : "";
    }

    public String PrefixEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Message.Prefix")) : "";
    }

    static {
        lang_it_config = YamlConfiguration.loadConfiguration(lang_it);
        lang_en_config = YamlConfiguration.loadConfiguration(lang_en);
        lang = Main.getInstance().getConfig().getString("Lang");
    }
}
