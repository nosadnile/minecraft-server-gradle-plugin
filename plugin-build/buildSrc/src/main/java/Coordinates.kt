object PluginCoordinates {
    const val ID = "net.nosadnile.gradle.minecraft.server"
    const val GROUP = "net.nosadnile.gradle.minecraft"
    const val VERSION = "3.0.0"
    const val IMPLEMENTATION_CLASS = "net.nosadnile.gradle.minecraft.server.MinecraftServerPlugin"
}

object PluginBundle {
    const val VCS = "https://github.com/nosadnile/minecraft-server-gradle-plugin"
    const val WEBSITE = "https://github.com/nosadnile/minecraft-server-gradle-plugin"
    const val DESCRIPTION = "Launch Minecraft servers using Gradle task. For Bukkit, Spigot, Paper, etc.."
    const val DISPLAY_NAME = "Launch Minecraft Servers Plugin"
    val TAGS = listOf(
        "minecraft",
        "bukkit",
        "spigot",
        "paper",
        "purpur"
    )
}
