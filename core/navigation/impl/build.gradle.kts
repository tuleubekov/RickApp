plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}

android {
    namespace = "com.berg.rickapp.core.navigation.impl"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
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