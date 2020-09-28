package com.bteaus.bteguidetour;

import org.bukkit.plugin.java.JavaPlugin;

/*
    ------------------
      BTE Guide Tour
    ------------------

    * Text
    - command / subcommand
    = text input

    * A customisable tour guide for tourists of BTE to explore around.
    * Commands:
    -   /tour
        - help = help list
        - create [tourname] <description> = creates empty tour.
        - info [tourname] = shows all warp points using GUI.
        - remove [tourname]
        - start [tourname]
        - list = list all tours
        =========== Tour Configuration ========
        - edit [tourname] = start edit mode,
            all text input will be classified as edit mode commands from now on.
    =   add
        - location [locationname] = adds empty location
        - point [locationname] [warp/] =
    =   list = shows list of locations within tour
    =   set
        - map
            - enable [true/false] = enables hand-held map when on tour mode.
            - zoom [locationname] [zoomlevel] = set's the maps zoom level
            - trail [locationname] [true/false] = the trial on map should/n't be shown when traveling.
        - description [description (Bukkit Code accepted)]

        -
 */


public final class BTEGuideTourSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        // If on bungee proxy, disable ALL commands Spigot side.
        // If on Bungee Proxy, enable plugin listeners.



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
