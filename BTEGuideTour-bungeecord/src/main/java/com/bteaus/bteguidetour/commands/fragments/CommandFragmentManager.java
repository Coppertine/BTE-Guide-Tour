package com.bteaus.bteguidetour.commands.fragments;

import com.bteaus.bteguidetour.util.ChatHelper;
import com.bteaus.bteguidetour.util.TextElement;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CommandFragmentManager extends Command {

    public CommandFragmentManager(String name, String node)
    {
        super(name, node);
    }

    public CommandFragmentManager(String name, String node, String[] alias)
    {
        super(name, node, alias);
    }

    private List<ICommandFragment> commandFragments = new ArrayList<>();
    private String title = "";
    private String commandBase = "";

    protected void registerCommandFragment(ICommandFragment c) {
        commandFragments.add(c);
    }

    protected void setTitle(String t) {
        this.title = " "+t;
    }

    protected void setCommandBase(String b) {
        this.commandBase = "/"+b+" ";
    }

    protected void executeFragment(CommandSender sender, String[] args) {
        if (args.length != 0) {
            ArrayList<String> dataList = new ArrayList<>(Arrays.asList(args).subList(1, args.length));

            String[] data = dataList.toArray(new String[dataList.size()]);
            for (ICommandFragment f : commandFragments) {
                if (f.getName().equals(args[0].toLowerCase())) {
                    f.execute(sender, data);
                    return;
                }
            }
        }
        displayCommands(sender, args);
    }

    private void displayCommands(CommandSender sender, String[] args) {
        sender.sendMessage(ChatHelper.getInstance().makeTitleTextComponent(new TextElement(title+":", ChatColor.GRAY)));
        for(ICommandFragment f : commandFragments) {

            List<TextElement> message = new ArrayList<>();
            message.add(new TextElement(commandBase, ChatColor.AQUA));
            message.add(new TextElement(f.getName()+" ", ChatColor.GREEN));
            if(f.getArguments() != null) {
                for(int x = 0; x < f.getArguments().length; x++) {
                    String argument = f.getArguments()[x];
                    if(argument.startsWith("<")) {
                        message.add(new TextElement(argument+" ", ChatColor.RED));
                    } else {
                        message.add(new TextElement(argument+" ", ChatColor.GRAY));
                    }
                }
            }
            message.add(new TextElement("- ", ChatColor.GRAY));
            message.add(new TextElement(f.getPurpose(), ChatColor.BLUE));

            sender.sendMessage(ChatHelper.getInstance().makeTextComponent(message.toArray(new TextElement[message.size()])));
        }
    }
}
