plugins {
    androidLibrary
}

android {
    namespace = "com.berg.rickapp.core.navigation.api"
}

dependencies {
    implementation(Deps.Core.fragmentKtx)
    implementation(Deps.Nav.navigationFragment)

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)
}