package com.bteaus.bteguidetour;


import com.bteaus.bteguidetour.config.Configuration;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;

public class BTEGuideTourUtils {
    public static ServerInfo getServerFromName(String name) {
        return ProxyServer.getInstance().getServerInfo(name);
    }

    public static ServerInfo getServerFromPlayerName(String name) {
        return ProxyServer.getInstance().getPlayer(name).getServer().getInfo();
    }


    public static boolean isGenuineRequest(String u) {
        try {
            return u.equals(Configuration.authenticationCode);
        } catch (Exception e) {
            BTEGuideTourBungeeCord.logger.info("Error occurred while parsing incoming authentication command!");
            return false;
        }
    }

    public static String getRawArguments(String[] args) {
        if(args.length == 0) {
            return "";
        } else if(args.length == 1) {
            return args[0];
        }

        String arguments = args[0];

        for(int x = 1; x < args.length; x++) {
            arguments+=" "+args[x];
        }

        return arguments;
    }
}
