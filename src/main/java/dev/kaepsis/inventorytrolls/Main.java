package dev.kaepsis.inventorytrolls;

import co.aikar.commands.PaperCommandManager;
import dev.kaepsis.inventorytrolls.commands.*;
import dev.kaepsis.inventorytrolls.configs.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new ShuffleCommand());
        manager.registerCommand(new RemoveItemCommand());
        manager.registerCommand(new AdminCommand());
        manager.registerCommand(new RemoveItemAllCommand());
        manager.registerCommand(new ShuffleAllCommand());
        Messages.getInstance().registerConfig(this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
