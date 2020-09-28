package com.bteaus.bteguidetour.commands.fragments.tour;

import com.bteaus.bteguidetour.commands.fragments.ICommandFragment;
import net.md_5.bungee.api.CommandSender;

public class CreateFragment implements ICommandFragment {
    @Override
    public void execute(CommandSender sender, String[] args) {

    }

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getPurpose() {
        return "Creates a new Tour";
    }

    @Override
    public String[] getArguments() {
        return new String[]{"<TourName>"};
    }
}
