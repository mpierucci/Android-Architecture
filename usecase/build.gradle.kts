import publications.GROUP_ID

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

publishing {
    publications {
        register("gpr", MavenPublication::class) {
            from(components["java"])
            groupId = GROUP_ID
            artifactId = artifactId
            version = "0.1.0"
            artifact("$buildDir/libs/$artifactId.jar")
        }
    }
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

