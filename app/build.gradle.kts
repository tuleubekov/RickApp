plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}

@Suppress("UnstableApiUsage")
android {
    namespace = Config.packageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk =  Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Deps.Core.appCompat)
    implementation(Deps.Network.retrofit)
    implementation(Deps.Di.dagger)
    kapt(Deps.Di.daggerCompiler)

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)

    // Modules
    implementation(project(Modules.Common.utils))
    implementation(project(Modules.Core.di))
    implementation(project(Modules.Core.navImpl))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))
    implementation(project(Modules.Core.presentation))
    implementation(project(Modules.Features.splash))
    implementation(project(Modules.Features.home))
    implementation(project(Modules.Features.details))
    implementation(project(Modules.Features.search))
}