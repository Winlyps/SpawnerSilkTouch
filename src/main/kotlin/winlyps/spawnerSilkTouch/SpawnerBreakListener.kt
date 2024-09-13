package winlyps.spawnerSilkTouch

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack

class SpawnerBreakListener(private val plugin: SpawnerSilkTouch) : Listener {

    @EventHandler
    fun onSpawnerBreak(event: BlockBreakEvent) {
        val player = event.player
        val block = event.block

        // Check if the block is a spawner
        if (block.type == Material.SPAWNER) {
            val tool = player.inventory.itemInMainHand

            // Check if the tool has Silk Touch enchantment
            if (tool.containsEnchantment(Enchantment.SILK_TOUCH)) {
                // Cancel the event to prevent the default drop
                event.isDropItems = false

                // Drop the spawner item
                block.world.dropItemNaturally(block.location, ItemStack(Material.SPAWNER))
            }
        }
    }
}