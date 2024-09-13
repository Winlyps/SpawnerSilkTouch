package winlyps.spawnerSilkTouch

import org.bukkit.plugin.java.JavaPlugin

class SpawnerSilkTouch : JavaPlugin() {

    override fun onEnable() {
        // Register the event listener
        server.pluginManager.registerEvents(SpawnerBreakListener(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}