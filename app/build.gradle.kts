plugins{
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.bulid)

    defaultConfig {
        applicationId = "com.github.fatemehmsp.covid_19tracker"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    viewBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    testImplementation("junit:junit:4.12")
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)

    implementation (Kotlin.kotlinStd7)
    implementation (Support.compat)
    implementation (Support.androidxCore)
    implementation (Support.constraintLayout)
    implementation(Support.recyclerView)

    implementation(Kotlin.coroutines)
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:1.0.0")

    implementation(Ui.navigationFragment)
    implementation(Ui.navigationUi)

    implementation(DaggerLibs.dagger)
    kapt(DaggerLibs.daggerCompiler)

    implementation(MoshiLibs.moshiRetrofit)
    implementation(MoshiLibs.moshi)


    implementation(Network.retrofit)
    implementation(Network.okHttp)
    implementation(Network.okHttpLogging)

    implementation(Network.paging)

}
