package com.bteaus.bteguidetour.config;

import com.bteaus.bteguidetour.BTEGuideTourBungeeCord;
import de.leonhard.storage.Config;
import de.leonhard.storage.Json;
import net.md_5.bungee.api.plugin.Plugin;

public class Configuration {
    private Plugin plugin = BTEGuideTourBungeeCord.guideTour;
    private Config configFile;

    public static String authenticationCode;
    public static String prefix;


    public Configuration()
    {

        configFile = new Config("config", plugin.getDataFolder().getPath());
        configFile.addHeader("BTE Guide Tour");
        authenticationCode = configFile.getString("Authentication Code");
        prefix = configFile.getOrSetDefault("prefix", "&6&l[BTE Tour]&r");


    }
}
