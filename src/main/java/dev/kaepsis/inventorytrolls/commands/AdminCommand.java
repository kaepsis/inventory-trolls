package dev.kaepsis.inventorytrolls.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.github.kaepsis.Chat;
import dev.kaepsis.inventorytrolls.configs.Messages;
import org.bukkit.command.CommandSender;

@CommandAlias("itreload")
@CommandPermission("inventorytrolls.admin")
public class AdminCommand extends BaseCommand {

    @Default
    public void root(CommandSender sender) {
        Chat.getInstance().send(sender, Messages.getInstance().reloadDone);
    }

}
