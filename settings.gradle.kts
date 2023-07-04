pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.4.1")
            }
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.8.0")
            }
        }
    }
}

rootProject.name = "RickApp"
include(":app")
include(":core")
include(":data")
include(":features:home")
include(":domain")
