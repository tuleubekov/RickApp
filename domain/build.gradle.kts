plugins {
    androidLibrary
    kotlin("kapt")
}

android {
    namespace = "com.berg.rickapp.domain"
}

dependencies {
    implementation(Deps.Core.paging)
    implementation(Deps.Di.dagger)
    kapt(Deps.Di.daggerCompiler)

    implementation(project(Modules.Common.utils))
}