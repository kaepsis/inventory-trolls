package dev.kaepsis.inventorytrolls.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.github.kaepsis.Chat;
import dev.kaepsis.inventorytrolls.InventoryUtils;
import dev.kaepsis.inventorytrolls.PlayerUtils;
import dev.kaepsis.inventorytrolls.configs.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("shuffle")
@CommandPermission("inventoryshuffle.shuffle")
@Description("Shuffles a player's inventory")
public class ShuffleCommand extends BaseCommand {

    @Default
    public void root(CommandSender sender) {
        Chat.getInstance().send(sender, Messages.getInstance().shuffleUsage);
    }

    @Default
    @Syntax("<player>")
    @CommandCompletion("@players")
    public void withArguments(CommandSender sender, String playerName) {
        PlayerUtils.getInstance().ensurePlayer(sender, playerName)
                .ifPresent(target -> InventoryUtils.getInstance().shuffle(target));
        Chat.getInstance().send(sender, Messages.getInstance().shuffleDone, "{playerName}", playerName);
    }
}
