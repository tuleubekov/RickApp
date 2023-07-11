plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}

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

    // Core Android dependencies
    implementation(Deps.Core.androidxCoreKtx)
    implementation(Deps.Core.appCompat)
    implementation(Deps.Core.material)
    implementation(Deps.Core.constraint)
    implementation(Deps.Core.splashScreen)

    // Nav
    implementation(Deps.Nav.navigationFragment)
    implementation(Deps.Nav.navigationUi)

    // Network
    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.retrofitLogging)

    // Di
    implementation(Deps.Di.dagger)
    kapt(Deps.Di.daggerCompiler)

    // Other
    implementation(Deps.Other.time)
    implementation(Deps.Other.glide)
    implementation(Deps.Other.timber)
    implementation(Deps.Other.viewBindingDelegate)

    // Tests
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espressoCore)

    // Modules
    implementation(project(Modules.core))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))
    implementation(project(Modules.Features.home))
}