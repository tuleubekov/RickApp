plugins {
    androidLibrary
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.berg.rickapp.data"
}

dependencies {
    // Network
    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.retrofitConverterKSerilization)
    implementation(Deps.Network.retrofitLogging)

    // Di
    implementation(Deps.Di.dagger)
    kapt(Deps.Di.daggerCompiler)

    // Other
    implementation(Deps.Core.paging)
    implementation(Deps.Other.kserialization)

    // Modules
    implementation(project(Modules.Common.utils))
    implementation(project(Modules.domain))
}