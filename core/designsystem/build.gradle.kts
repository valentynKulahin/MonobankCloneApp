plugins {
    alias(libs.plugins.monobankcloneapp.android.library)
    alias(libs.plugins.monobankcloneapp.android.compose)
}

android {
    namespace = "com.example.designsystem"
}

dependencies {

    implementation(project(":core:common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}