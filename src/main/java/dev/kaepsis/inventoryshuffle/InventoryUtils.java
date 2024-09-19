package dev.kaepsis.inventoryshuffle;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InventoryUtils {

    public static void shuffle(Player player) {
        Inventory inventory = player.getInventory();
        List<ItemStack> contents = Arrays.asList(inventory.getContents());
        Collections.shuffle(contents);
        inventory.setContents(contents.toArray(new ItemStack[0]));
    }

}
