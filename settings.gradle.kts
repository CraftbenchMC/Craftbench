rootProject.name = "Craftbench"
include("api", "loader")

pluginManagement {
    repositories {
        maven {
            name = "CraftbenchMC Maven"
            url = uri("https://craftbenchmc.github.io/maven/")
        }

        maven {
            name = "FabricMC Maven"
            url = uri("https://maven.fabricmc.net/")
        }

        maven {
            name = "QuiltMC Maven"
            url = uri("https://maven.quiltmc.org/")
        }

        gradlePluginPortal()
		mavenLocal()
    }
}
