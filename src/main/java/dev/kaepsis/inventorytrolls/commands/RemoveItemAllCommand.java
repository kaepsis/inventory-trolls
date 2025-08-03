package dev.kaepsis.inventorytrolls.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.github.kaepsis.Chat;
import dev.kaepsis.inventorytrolls.InventoryUtils;
import dev.kaepsis.inventorytrolls.configs.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

@CommandAlias("removeitemall")
@CommandPermission("inventorytrolls.removeitem.all")
@Description("Removes an amount of random items from all players' inventories")
public class RemoveItemAllCommand extends BaseCommand {

    @Default
    public void root(CommandSender sender) {
        Chat.getInstance().send(sender, Messages.getInstance().removeItemAllUsage);
    }

    @Default
    @Syntax("<player>")
    public void withArguments(CommandSender sender, int times) {
        Bukkit.getOnlinePlayers()
                .stream()
                .filter(player -> !player.hasPermission("inventorytrolls.extempt"))
                .forEach(player -> InventoryUtils.getInstance().removeRandomItem(player, times));
        Chat.getInstance().send(sender, Messages.getInstance().removeItemAllDone);
    }
}
