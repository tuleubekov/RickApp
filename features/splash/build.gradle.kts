plugins {
    androidLibrary
    kotlin("kapt")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.berg.rickapp.features.splash"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.Compose.versionCompose
    }
}

dependencies {
    // Core Android dependencies
    implementation(Deps.Core.androidxCoreKtx)
    implementation(Deps.Core.fragmentKtx)
    implementation(Deps.Core.appCompat)
    implementation(Deps.Core.material)
    implementation(Deps.Core.splashScreen)

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
    implementation(Deps.Compose.viewModelCompose)
    implementation(Deps.Compose.toolingPreview)
    debugImplementation(Deps.Compose.uiTooling)
    implementation(Deps.Compose.accomponistThemeAdapterMaterial)

    // Di
    implementation(Deps.Di.dagger)
    kapt(Deps.Di.daggerCompiler)

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)

    // Modules
    implementation(project(Modules.Common.ui))
    implementation(project(Modules.Common.utils))
    implementation(project(Modules.Core.di))
    implementation(project(Modules.Core.navApi))
    implementation(project(Modules.Core.presentation))
}