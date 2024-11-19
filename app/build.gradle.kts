import com.example.convention.monobankcloneapp.AppBuildType

plugins {
    alias(libs.plugins.monobankcloneapp.android.application)
    alias(libs.plugins.monobankcloneapp.android.application.compose)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.monobankcloneapp.hilt)
}

android {
    namespace = "com.example.monobankcloneapp"

    defaultConfig {
        applicationId = "com.example.monobankcloneapp"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            applicationIdSuffix = AppBuildType.DEBUG.applicationIdSuffix
        }
        release {
            applicationIdSuffix = AppBuildType.RELEASE.applicationIdSuffix
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:database"))
    implementation(project(":core:datastore"))
    implementation(project(":core:datastore-proto"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    implementation(project(":core:models"))
    implementation(project(":core:network"))

    implementation(project(":ui:dashboard"))
    implementation(project(":ui:savings"))
    implementation(project(":ui:credits"))
    implementation(project(":ui:more"))
    implementation(project(":ui:cashback"))

    implementation(project(":feature:accountInfo"))
    implementation(project(":feature:accountsettings"))
    implementation(project(":feature:auth"))
    implementation(project(":feature:expensemoney"))
    implementation(project(":feature:depositmoney"))
    implementation(project(":feature:transfermoney"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    ksp(libs.hilt.compiler)

    //tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}