object Deps {

    object Core {
        private const val versionCoreKtx = "1.10.1"
        private const val versionFragmentKtx = "1.5.5"
        private const val versionAppCompat = "1.6.1"
        private const val versionMaterial = "1.9.0"
        private const val versionConstraint = "2.1.4"
        private const val versionSplash = "1.0.1"

        const val androidxCoreKtx = "androidx.core:core-ktx:$versionCoreKtx"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:$versionFragmentKtx"
        const val appCompat = "androidx.appcompat:appcompat:$versionAppCompat"
        const val material = "com.google.android.material:material:$versionMaterial"
        const val constraint = "androidx.constraintlayout:constraintlayout:$versionConstraint"
        const val splashScreen = "androidx.core:core-splashscreen:$versionSplash"
    }

    object Nav {
        private const val versionNav = "2.4.2"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$versionNav"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$versionNav"
    }

    object Network {
        private const val versionRetrofit = "2.9.0"
        private const val versionLogging = "4.11.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$versionRetrofit"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:$versionRetrofit"
        const val retrofitLogging = "com.squareup.okhttp3:logging-interceptor:$versionLogging"
    }

    object Di {
        private const val versionDagger = "2.46.1"
        const val dagger = "com.google.dagger:dagger:$versionDagger"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:$versionDagger"
    }

    object Other {
        private const val versionGson = "2.10.1"
        private const val versionTime = "0.4.0"
        private const val versionGlide = "4.15.1"
        private const val versionViewBindingDelegate = "1.5.9"
        private const val versionTimber = "5.0.1"

        const val gson = "com.google.code.gson:gson:$versionGson"
        const val time = "org.jetbrains.kotlinx:kotlinx-datetime:$versionTime"
        const val glide = "com.github.bumptech.glide:glide:$versionGlide"
        const val timber = "com.jakewharton.timber:timber:$versionTimber"
        const val viewBindingDelegate =
            "com.github.kirich1409:viewbindingpropertydelegate-noreflection:$versionViewBindingDelegate"
    }

    object Test {
        private const val versionJunit = "4.13.2"
        private const val versionExtJunit = "1.1.5"
        private const val versionEspressoCore = "3.5.1"

        const val junit = "junit:junit:$versionJunit"
        const val extJunit = "androidx.test.ext:junit:$versionExtJunit"
        const val espressoCore = "androidx.test.espresso:espresso-core:$versionEspressoCore"
    }
}