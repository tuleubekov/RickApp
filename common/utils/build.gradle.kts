plugins {
    androidLibrary
}

android {
    namespace = "com.berg.rickapp.common.utils"
}

dependencies {
    implementation(Deps.Other.timber)

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)
}