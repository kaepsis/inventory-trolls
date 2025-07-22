package dev.kaepsis.inventorytrolls;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InventoryUtils {

    private static InventoryUtils instance = null;

    public static InventoryUtils getInstance() {
        if (instance == null) {
            instance = new InventoryUtils();
        }
        return instance;
    }

    private InventoryUtils() {}

    public void shuffle(Player player) {
        Inventory inventory = player.getInventory();
        List<ItemStack> contents = Arrays.asList(inventory.getContents());
        Collections.shuffle(contents);
        inventory.setContents(contents.toArray(new ItemStack[0]));
    }

    public void removeRandomItem(Player player, int times) {
        Inventory inventory = player.getInventory();
        List<ItemStack> nonEmptyItems = Arrays.stream(inventory.getContents())
                .filter(item -> item != null && item.getType() != Material.AIR)
                .toList();
        if (nonEmptyItems.isEmpty()) return;
        for (int i = 0; i < times; i++) {
            List<ItemStack> currentItems = Arrays.stream(inventory.getContents())
                    .filter(item -> item != null && item.getType() != Material.AIR)
                    .toList();
            if (currentItems.isEmpty()) break;
            ItemStack randomItem = currentItems.get(ThreadLocalRandom.current().nextInt(currentItems.size()));
            int index = inventory.first(randomItem);
            inventory.setItem(index, null);
        }
    }


}
