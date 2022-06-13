plugins {
    id("java")
    id("maven-publish")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }

        withJavadocJar()
        withSourcesJar()
    }

    publishing {
        repositories {
            maven {
                url = uri(rootProject.rootDir.toString() + "/maven")
            }
        }
    }

    tasks.named("build") {
        dependsOn("javadocJar")
        dependsOn("sourcesJar")
        dependsOn("publish")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.github.craftbenchmc"
            artifactId = "craftbench"
            version = "0.1.0"

            from(components["java"])
        }
    }
}
