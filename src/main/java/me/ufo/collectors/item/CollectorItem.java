package me.ufo.collectors.item;

import me.ufo.collectors.CollectorsPlugin;
import me.ufo.collectors.util.Style;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CollectorItem {

  private static final FileConfiguration config = CollectorsPlugin.getInstance().getConfig();
  private static final String PATH = "collector-item.";

  public static ItemStack get() {
    ItemStack item = new ItemStack(Material.BEACON);
    ItemMeta itemMeta = item.getItemMeta();
    itemMeta.setDisplayName(Style.translate(config.getString(PATH + "name")));
    itemMeta.setLore(Style.translate(config.getStringList(PATH + "lore")));
    item.setItemMeta(itemMeta);

    return item;
  }

  public static ItemStack get(int amount) {
    ItemStack item = new ItemStack(Material.BEACON, amount);
    ItemMeta itemMeta = item.getItemMeta();
    itemMeta.setDisplayName(Style.translate(config.getString(PATH + "name")));
    itemMeta.setLore(Style.translate(config.getStringList(PATH + "lore")));
    item.setItemMeta(itemMeta);

    return item;
  }

  public static boolean is(ItemStack itemStack) {
    if (itemStack == null || !itemStack.hasItemMeta()) return false;
    ItemStack collectorItem = CollectorItem.get();
    if (itemStack.getType() != collectorItem.getType()) return false;

    return itemStack.isSimilar(collectorItem);
  }

}