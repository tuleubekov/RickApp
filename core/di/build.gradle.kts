plugins {
    androidLibrary
}

android {
    namespace = "com.berg.rickapp.core.di"
}

dependencies {
    implementation(Deps.Di.dagger)

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)
}