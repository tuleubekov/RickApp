plugins {
    androidLibrary
    kotlin("kapt")
}

android {
    namespace = "com.berg.rickapp.core.presentation"
}

dependencies {
    implementation(Deps.Core.androidxCoreKtx)
    implementation(Deps.Core.appCompat)
    implementation(Deps.Di.dagger)
    kapt(Deps.Di.daggerCompiler)

    // Modules
    implementation(project(Modules.Common.utils))
    implementation(project(Modules.Common.ui))
    implementation(project(Modules.Core.navApi))

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)
}