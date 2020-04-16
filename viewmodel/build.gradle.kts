import properties.gitHubProperties
import publications.GROUP_ID

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("maven-publish")
}

android {
    compileSdkVersion(Android.compileSdkVersion)
    buildToolsVersion(Android.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Android.minSdkVersion)
        targetSdkVersion(Android.targetSdkVersion)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    sourceSets["main"].java.srcDir("src/main/kotlin")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))


    implementation(kotlin("stdlib-jdk8"))
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.2.0")
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    implementation("androidx.activity:activity-ktx:1.1.0")
    implementation("androidx.fragment:fragment-ktx:1.2.2")
}


val artifactID = "viewmodel"
val version = "0.1.2"

publishing {
    publications {
        register("gpr", MavenPublication::class) {
            groupId = GROUP_ID
            artifactId = artifactID
            version = "0.1.2"
            artifact("$buildDir/outputs/aar/$artifactID-release.aar")
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/mpierucci/Android-Architecture")
            credentials {
                username =
                    project.gitHubProperties.getProperty("gpr.usr") ?: System.getenv("GPR_USER")
                password =
                    project.gitHubProperties.getProperty("gpr.key") ?: System.getenv("GPR_API_KEY")
            }
        }
    }
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

