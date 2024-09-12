buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    //kotlin 2.0.0 için
    alias(libs.plugins.compose.compiler) apply false

    //ksp
    alias(libs.plugins.devtools.ksp) apply false

    //hilt
    alias(libs.plugins.dagger.hilt.android) apply false

    //serialization (navigation için)
    alias(libs.plugins.kotlinx.serialization) apply false

    //detekt
    alias(libs.plugins.detekt) apply false
}