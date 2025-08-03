package dev.kaepsis.inventorytrolls.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.github.kaepsis.Chat;
import dev.kaepsis.inventorytrolls.InventoryUtils;
import dev.kaepsis.inventorytrolls.PlayerUtils;
import dev.kaepsis.inventorytrolls.configs.Messages;
import org.bukkit.command.CommandSender;

@CommandAlias("removeitem")
@CommandPermission("inventorytrolls.removeitem")
@Description("Removes an amount of random items from a player's inventory")
public class RemoveItemCommand extends BaseCommand {

    @Default
    public void root(CommandSender sender) {
        Chat.getInstance().send(sender, Messages.getInstance().removeItemUsage);
    }

    @Default
    @Syntax("<player>")
    @CommandCompletion("@players")
    public void withArguments(CommandSender sender, String playerName, int times) {
        PlayerUtils.getInstance().ensurePlayer(sender, playerName)
                .ifPresent(target -> InventoryUtils.getInstance().removeRandomItem(target, times));
        Chat.getInstance().send(sender, Messages.getInstance().removeItemDone, "{playerName}", playerName);
    }

}
