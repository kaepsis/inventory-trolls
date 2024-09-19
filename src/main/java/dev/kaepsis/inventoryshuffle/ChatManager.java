package dev.kaepsis.inventoryshuffle;

import org.bukkit.ChatColor;

public class ChatManager {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
