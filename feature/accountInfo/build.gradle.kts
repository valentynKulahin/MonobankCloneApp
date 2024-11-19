plugins {
    alias(libs.plugins.monobankcloneapp.android.library)
    alias(libs.plugins.monobankcloneapp.android.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.monobankcloneapp.hilt)
}

android {
    namespace = "com.example.accountinfo"
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":core:models"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    ksp(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}