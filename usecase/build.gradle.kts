import publications.GROUP_ID
import java.io.FileInputStream
import java.util.*

plugins {
    id("kotlin")
    id("java-library")
    id("maven-publish")
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlinStdlib)

}
java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

val artifactID = "usecase"


val githubProperties = Properties()
githubProperties.load(FileInputStream(rootProject.file("github.properties")))


publishing {
    publications {

        register("gpr", MavenPublication::class) {
            from(components["java"])
            groupId = GROUP_ID
            artifactId = artifactId
            version = "0.1.0"
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/mpierucci/Android-Architecture")
            credentials {
                username = githubProperties.getProperty("gpr.usr") ?: System.getenv("GPR_USER")
                password = githubProperties.getProperty("gpr.key") ?: System.getenv("GPR_API_KEY")
            }
        }
    }
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

