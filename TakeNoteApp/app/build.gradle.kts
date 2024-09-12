plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    //kotlin 2.0.0 için
    alias(libs.plugins.compose.compiler)

    //ksp
    alias(libs.plugins.devtools.ksp)

    //hilt
    alias(libs.plugins.dagger.hilt.android)

    //serialization (navigation için)
    alias(libs.plugins.kotlinx.serialization)

    //navigation için
    id("kotlin-parcelize")

    //detekt
    alias(libs.plugins.detekt)
}

android {
    namespace = "com.mustafatoktas.nottut"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mustafatoktas.nottut"
        minSdk = 27
        targetSdk = 34
        versionCode = 3
        versionName = "1.2.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    //kendi eklediğim
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //room
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    //hilt
    implementation(libs.dagger.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.dagger.hilt.compiler)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //splash screen
    implementation(libs.androidx.core.splashscreen)

    //icon paketi
    implementation(libs.androidx.material.icons.extended)

    //datastore
    implementation(libs.androidx.datastore.preferences)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    //serialization (navigation için)
    implementation(libs.kotlinx.serialization.json)

    //özelleştirilebilir snackbar
    implementation(libs.sonner)

    //coil (image cashing)
    implementation(libs.coil.compose)
    implementation(libs.coil.gif) // gifleri oynatmak için (zorunlu değil)

    //ketch (indirme yöneticisi)
    implementation (libs.ketch)

    //detekt
    detektPlugins(libs.detekt)
}

//detekt yapılandırması
detekt {
    config.setFrom(file("$rootDir/detekt/detektConfig.yml"))
    source.from(files("src/main/kotlin", "src/test/kotlin"))
    parallel = true
    autoCorrect = true
    buildUponDefaultConfig = true
}