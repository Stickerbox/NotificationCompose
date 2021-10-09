import io.gitlab.arturbosch.detekt.detekt

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
    id("org.jmailen.kotlinter")

    kotlin("android")
    kotlin("kapt")
}

detekt {
    source = files("src/main/java", "src/main/kotlin")
    config = rootProject.files("build-config/detekt.yml")
    buildUponDefaultConfig = true

    reports {
        sarif {
            enabled = true
        }
    }
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.konradgroup.notificationcompose"
        minSdk = 26
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.3"
    }

    packagingOptions {
        resources {
            excludes += "META-INF/AL2.0"
            excludes += "META-INF/LGPL2.1"
        }
    }

    lint {
        lintConfig = rootProject.file("build-config/lint.xml")
        isWarningsAsErrors = true
        sarifReport = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.compose.ui:ui:1.0.3")
    implementation("androidx.compose.material:material:1.0.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.0.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-rc01")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")

    implementation("com.google.dagger:hilt-android:2.39.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    kapt("com.google.dagger:hilt-compiler:2.39.1")

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.0.3")
}
