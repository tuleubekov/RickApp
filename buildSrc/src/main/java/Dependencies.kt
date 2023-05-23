object Dependencies {

    object Core {
        private const val versionCoreKtx = "1.10.1"
        private const val versionAppCompat = "1.6.1"
        private const val versionMaterial = "1.9.0"
        private const val versionConstraint = "2.1.4"

        const val androidxCoreKtx = "androidx.core:core-ktx:$versionCoreKtx"
        const val appCompat = "androidx.appcompat:appcompat:$versionAppCompat"
        const val material = "com.google.android.material:material:$versionMaterial"
        const val constraint = "androidx.constraintlayout:constraintlayout:$versionConstraint"
    }

    object Network {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Other {
        private const val versionGson = "2.10.1"
        private const val versionTime = "0.4.0"

        const val gson = "com.google.code.gson:gson:$versionGson"
        const val time = "org.jetbrains.kotlinx:kotlinx-datetime:$versionTime"
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