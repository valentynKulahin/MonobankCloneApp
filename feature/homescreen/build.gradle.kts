plugins {
    alias(libs.plugins.monobankcloneapp.android.library)
    alias(libs.plugins.monobankcloneapp.android.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.monobankcloneapp.hilt)
}

android {
    namespace = "com.example.homescreen"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}