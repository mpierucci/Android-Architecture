import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id ("org.jetbrains.kotlin.jvm") version Libs.kotlinVersion
}

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(BuildPlugins.androidGradle)
        classpath(BuildPlugins.kotlin)
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.1.1")
        classpath(BuildPlugins.googlePlay)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

repositories {
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
