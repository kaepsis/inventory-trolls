package dev.kaepsis.inventorytrolls;

import co.aikar.commands.PaperCommandManager;
import dev.kaepsis.inventorytrolls.commands.AdminCommand;
import dev.kaepsis.inventorytrolls.commands.RemoveItemCommand;
import dev.kaepsis.inventorytrolls.commands.ShuffleCommand;
import dev.kaepsis.inventorytrolls.configs.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new ShuffleCommand());
        manager.registerCommand(new RemoveItemCommand());
        manager.registerCommand(new AdminCommand());
        Messages.getInstance().registerConfig(this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
