package dev.kaepsis.inventoryshuffle.commands;

import dev.kaepsis.inventoryshuffle.ChatManager;
import dev.kaepsis.inventoryshuffle.InventoryUtils;
import dev.kaepsis.inventoryshuffle.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class ShuffleCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length == 0) {
            commandSender.sendMessage(ChatManager.color(Messages.USAGE));
            return true;
        }
        String playerName = args[0];
        Player target = Bukkit.getPlayer(playerName);
        if(target == null) {
            commandSender.sendMessage(ChatManager.color(Messages.PLAYER_NOT_FOUND).replace("{playerName}", playerName));
            return true;
        }
        InventoryUtils.shuffle(target);
        commandSender.sendMessage(ChatManager.color(Messages.INVENTORY_SHUFFLED).replace("{playerName}", target.getName()));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length == 1) {
            return Bukkit.getOnlinePlayers().stream().map(Player::getName).toList();
        }
        return List.of();
    }
}
