// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.39.1")
    }

    repositories {
        google()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
