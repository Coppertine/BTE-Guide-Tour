package com.bteaus.bteguidetour.commands.fragments.tour;

import com.bteaus.bteguidetour.commands.fragments.ICommandFragment;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class GiveMapFragment implements ICommandFragment {
    @Override
    public void execute(CommandSender sender, String[] args) {

    }

    @Override
    public String getName() {
        return "give map";
    }

    @Override
    public String getPurpose() {
        return "Gives the map of your current position to you.";
    }

    @Override
    public String[] getArguments() {
        return null;
    }
}
