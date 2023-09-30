plugins {
    androidLibrary
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.berg.rickapp.common.ui"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.Compose.versionCompose
    }
}

dependencies {
    // Core
    implementation(Deps.Core.androidxCoreKtx)
    implementation(Deps.Core.appCompat)

    // Compose
    val composeBom = platform(Deps.Compose.composeBom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(Deps.Compose.runtime)
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.foundationLayout)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.runtimeLivedata)
    implementation(Deps.Compose.toolingPreview)
    debugImplementation(Deps.Compose.uiTooling)
    implementation(Deps.Compose.accomponistThemeAdapterMaterial)

    // Images
    implementation(Deps.Other.glideCompose)
    implementation(Deps.Other.coilCompose)

    // Modules
    implementation(project(Modules.Common.utils))

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)
}