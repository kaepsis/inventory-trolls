package dev.kaepsis.inventoryshuffle;

import dev.kaepsis.inventoryshuffle.commands.ShuffleCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryShuffle extends JavaPlugin {

    public static InventoryShuffle instance;

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getCommand("inventoryshuffle").setExecutor(new ShuffleCommand());
        getCommand("inventoryshuffle").setTabCompleter(new ShuffleCommand());
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
