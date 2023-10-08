plugins {
    androidLibrary
    kotlin("kapt")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.berg.rickapp.core.presentation"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.Compose.versionCompose
    }
}

dependencies {
    implementation(Deps.Core.androidxCoreKtx)
    implementation(Deps.Core.appCompat)
    implementation(Deps.Di.dagger)
    kapt(Deps.Di.daggerCompiler)

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
    implementation(Deps.Compose.lifecycleRuntimeCompose)
    implementation(Deps.Compose.toolingPreview)
    debugImplementation(Deps.Compose.uiTooling)
    implementation(Deps.Compose.accomponistThemeAdapterMaterial)

    // Modules
    implementation(project(Modules.Common.utils))
    implementation(project(Modules.Common.ui))
    implementation(project(Modules.Core.navApi))

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)
}