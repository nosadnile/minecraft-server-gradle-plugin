pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/nosadnile/minecraft-server-gradle-plugin")

            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

rootProject.name = ("net.nosadnile.gradle.minecraft.server")

include(":plugin")
