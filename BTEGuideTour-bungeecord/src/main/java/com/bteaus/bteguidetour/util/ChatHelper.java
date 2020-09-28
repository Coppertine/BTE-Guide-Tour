package com.bteaus.bteguidetour.util;

import com.bteaus.bteguidetour.Constants;
import com.bteaus.bteguidetour.config.Configuration;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;


public class ChatHelper {
    private static ChatHelper instance = null;

    public static ChatHelper getInstance() {
        return instance == null ? new ChatHelper() : instance;
    }

    public TextComponent makeTitleTextComponent(TextElement... text) {
        TextComponent bar = new TextComponent(Configuration.prefix.replace("&","\u00A7"));
        for (TextElement textElement : text) {
            TextComponent temp = new TextComponent(textElement.text);
            temp.setColor(textElement.color);
            temp.setBold(text[0].bold);
            bar.addExtra(temp);
        }
        return bar;
    }

    public TextComponent makeAdminTextComponent(TextElement... text) {
        TextComponent bar = new TextComponent(Constants.adminMessagePrefix.replace("&","\u00A7"));
        for (TextElement textElement : text) {
            TextComponent temp = new TextComponent(textElement.text);
            temp.setColor(textElement.color);
            temp.setBold(text[0].bold);
            bar.addExtra(temp);
        }
        return bar;
    }

    public TextComponent makeTextComponent(TextElement... text) {
        TextComponent bar = new TextComponent();
        for (TextElement textElement : text) {
            TextComponent temp = new TextComponent(textElement.text);
            temp.setColor(textElement.color);
            temp.setBold(text[0].bold);
            bar.addExtra(temp);
        }
        return bar;
    }

    public void infoMessage(CommandSender sender) {
        sender.sendMessage(makeTextComponent(new TextElement("-----------------------", ChatColor.DARK_AQUA),
                new TextElement("\nBTE Guide Tour ", ChatColor.AQUA), new TextElement("v."+ Constants.VERSION, ChatColor.DARK_AQUA),
                new TextElement("\nDeveloped by: ", ChatColor.AQUA), new TextElement("Coppertine", ChatColor.DARK_AQUA),
                new TextElement("\n-----------------------",ChatColor.DARK_AQUA)));
    }

    public static String capitalize(final String str) {
        final int strLen = length(str);
        if (strLen == 0) return str;

        final int firstCodepoint = str.codePointAt(0);
        final int newCodePoint = Character.toTitleCase(firstCodepoint);
        // already capitalized
        if (firstCodepoint == newCodePoint) return str;

        final int[] newCodePoints = new int[strLen]; // cannot be longer than the char array
        int outOffset = 0;
        newCodePoints[outOffset++] = newCodePoint; // copy the first codepoint
        int inOffset = Character.charCount(firstCodepoint);
        while (inOffset < strLen) {
            final int codepoint = str.codePointAt(inOffset);
            newCodePoints[outOffset++] = codepoint; // copy the remaining ones
            inOffset += Character.charCount(codepoint);
        }
        return new String(newCodePoints, 0, outOffset);
    }


    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }
}
