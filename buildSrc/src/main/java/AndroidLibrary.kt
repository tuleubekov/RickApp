import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.currentBuildId
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidLibrary : Plugin<Project> {

    override fun apply(project: Project) = project.androidLibrary()

    private fun Project.androidLibrary() {
        plugins.run {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
        }

        repositories {
            google()
            mavenCentral()
        }

        android {
            compileSdk = Config.compileSdk

            defaultConfig {
                minSdk = Config.minSdk
                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro",
                    )
                }
            }

            //configureUmsFlavor()
        }

        tasks.withType<KotlinCompile>()
            .configureEach {
                kotlinOptions {
                    freeCompilerArgs = freeCompilerArgs + listOf(
                        "-opt-in=kotlin.RequiresOptIn",
                        "-Xcontext-receivers",
                    )
                }
            }
    }

}

internal fun Project.android(configure: Action<LibraryExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)