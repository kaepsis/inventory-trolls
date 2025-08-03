package dev.kaepsis.inventorytrolls;

import com.github.kaepsis.Chat;
import dev.kaepsis.inventorytrolls.configs.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Optional;

public class PlayerUtils {

    private PlayerUtils() {}

    private static PlayerUtils instance = null;

    public static PlayerUtils getInstance() {
        if (instance == null) {
            instance = new PlayerUtils();
        }
        return instance;
    }

    public Optional<Player> ensurePlayer(CommandSender sender, String playerName) {
        Player player = Main.instance.getServer().getPlayer(playerName);
        if(player == null) {
            Chat.getInstance().send(
                    sender,
                    Messages.getInstance().playerNotFound,
                    "{playerName}", playerName
            );
            return Optional.empty();
        }
        if (player.hasPermission("inventorytrolls.extempt")) {
            Chat.getInstance().send(
                    sender,
                    Messages.getInstance().playerExempt,
                    "{playerName}", playerName
            );
            return Optional.empty();
        }
        return Optional.of(player);
    }

}
