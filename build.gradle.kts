plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.contactsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.contactsapp"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    viewBinding {
      enable = true
    }
    dataBinding {
        enable = true
    }

}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.8"))

    // Room dependencies
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // Lifecycle dependencies
    val lifecycle_version = "2.8.4"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    // Android support libraries
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Unit testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
