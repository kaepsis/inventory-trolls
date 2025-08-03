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
        ItemStack[] contents = inventory.getContents();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = contents.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            ItemStack a = contents[index];
            contents[index] = contents[i];
            contents[i] = a;
        }
        inventory.setContents(contents);
    }

    public void removeRandomItem(Player player, int times) {
        Inventory inventory = player.getInventory();
        ItemStack[] contents = inventory.getContents();
        int nonEmptyCount = countNonEmptyItems(contents);
        if (nonEmptyCount <= 0) return;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int removed = 0; removed < times && nonEmptyCount > 0; removed++) {
            int targetItem = random.nextInt(nonEmptyCount);
            int slot = findNthNonEmptySlot(contents, targetItem);
            inventory.setItem(slot, null);
            nonEmptyCount--;
        }
    }

    private int countNonEmptyItems(ItemStack[] items) {
        int count = 0;
        for (ItemStack item : items) {
            if (isNonEmpty(item)) {
                count++;
            }
        }
        return count;
    }

    private int findNthNonEmptySlot(ItemStack[] items, int targetIndex) {
        int currentIndex = 0;
        for (int slot = 0; slot < items.length; slot++) {
            if (!isNonEmpty(items[slot])) continue;
            if (currentIndex == targetIndex) return slot;
            currentIndex++;
        }
        return -1;
    }

    private boolean isNonEmpty(ItemStack item) {
        return item != null && item.getType() != Material.AIR;
    }



}
