import properties.gitHubProperties
import publications.GROUP_ID
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java-library")
    id("maven-publish")
    kotlin("jvm") // version "1.3.72" no version required since this is already on the classpath
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk8"))

}
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val artifactID = "usecase"
val version = "0.1.0"

publishing {
    publications {

        register("gpr", MavenPublication::class) {
            from(components["java"])
            groupId = GROUP_ID
            artifactId = artifactId
            version = version
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/mpierucci/Android-Architecture")
            credentials {
                username = project.gitHubProperties.getProperty("gpr.usr") ?: System.getenv("GPR_USER")
                password = project.gitHubProperties.getProperty("gpr.key") ?: System.getenv("GPR_API_KEY")
            }
        }
    }
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}