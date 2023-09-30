plugins {
    androidLibrary
    kotlin("kapt")
}

android {
    namespace = "com.berg.rickapp.core.navigation.impl"
}

dependencies {
    // Nav
    implementation(Deps.Nav.navigationFragment)
    implementation(Deps.Nav.navigationUi)

    // Di
    implementation(Deps.Di.dagger)
    kapt(Deps.Di.daggerCompiler)

    // Modules
    api(project(Modules.Core.navApi))
    implementation(project(Modules.Common.ui))
    implementation(project(Modules.Common.utils))
    implementation(project(Modules.Core.di))
    implementation(project(Modules.Features.tabs))
    implementation(project(Modules.Features.splash))
    implementation(project(Modules.Features.home))
    implementation(project(Modules.Features.details))
    implementation(project(Modules.Features.search))

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)
}