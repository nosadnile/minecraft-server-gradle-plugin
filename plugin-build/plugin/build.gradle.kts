plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.8.21"
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
    id("maven-publish")
}

publishing {
    repositories {
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

dependencies {
    implementation(kotlin("stdlib-jdk7"))
    implementation(gradleApi())
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
    plugins {
        create(PluginCoordinates.ID) {
            id = PluginCoordinates.ID
            implementationClass = PluginCoordinates.IMPLEMENTATION_CLASS
            version = PluginCoordinates.VERSION
        }
    }
}

// Configuration Block for the Plugin Marker artifact on Plugin Central
pluginBundle {
    website = PluginBundle.WEBSITE
    vcsUrl = PluginBundle.VCS
    description = PluginBundle.DESCRIPTION
    tags = PluginBundle.TAGS

    plugins {
        getByName(PluginCoordinates.ID) {
            displayName = PluginBundle.DISPLAY_NAME
        }
    }

    mavenCoordinates {
        groupId = PluginCoordinates.GROUP
        artifactId = PluginCoordinates.ID
        version = PluginCoordinates.VERSION
    }
}

tasks.create("setupPluginUploadFromEnvironment") {
    doLast {
        val key = System.getenv("GRADLE_PUBLISH_KEY")
        val secret = System.getenv("GRADLE_PUBLISH_SECRET")

        if (key == null || secret == null) {
            throw GradleException("gradlePublishKey and/or gradlePublishSecret are not defined environment variables")
        }

        System.setProperty("gradle.publish.key", key)
        System.setProperty("gradle.publish.secret", secret)
    }
}
