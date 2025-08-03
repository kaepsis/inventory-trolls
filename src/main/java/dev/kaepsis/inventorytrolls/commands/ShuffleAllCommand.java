package dev.kaepsis.inventorytrolls.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import com.github.kaepsis.Chat;
import dev.kaepsis.inventorytrolls.InventoryUtils;
import dev.kaepsis.inventorytrolls.configs.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

@CommandAlias("shuffleall")
@CommandPermission("inventoryshuffle.shuffle.all")
@Description("Shuffles all players' inventories")
public class ShuffleAllCommand extends BaseCommand {

    @Default
    public void root(CommandSender sender) {
        Bukkit.getOnlinePlayers()
                .stream()
                .filter(player -> !player.hasPermission("inventorytrolls.extempt"))
                .forEach(player -> InventoryUtils.getInstance().shuffle(player));
        Chat.getInstance().send(sender, Messages.getInstance().shuffleAllDone);
    }

}
