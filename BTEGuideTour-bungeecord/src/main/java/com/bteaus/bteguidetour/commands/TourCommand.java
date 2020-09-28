package com.bteaus.bteguidetour.commands;

import com.bteaus.bteguidetour.commands.fragments.CommandFragmentManager;
import com.bteaus.bteguidetour.commands.fragments.tour.CreateFragment;
import net.md_5.bungee.api.CommandSender;

public class TourCommand extends CommandFragmentManager {

    public TourCommand()
    {
        super("tour", "bteguidetour.tour");
        setCommandBase("tour");

        setTitle("BTE Tour Guide Commands");

        registerCommandFragment(new CreateFragment());
    }

    /**
     * Execute this command with the specified sender and arguments.
     *
     * @param sender the executor of this command
     * @param args   arguments used to invoke this command
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        executeFragment(sender, args);
    }
}
