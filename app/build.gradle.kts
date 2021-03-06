plugins{
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
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

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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

    implementation(ArchComponent.lifecycleExtension)
    implementation(ArchComponent.lifecycleViewModel)
    implementation(ArchComponent.lifecycleLiveData)

    implementation(Ui.navigationFragment)
    implementation(Ui.navigationUi)
    implementation(Ui.glide)
    kapt(Ui.glideCompiler)

    implementation(DaggerLibs.dagger)
    kapt(DaggerLibs.daggerCompiler)

    implementation(MoshiLibs.moshiRetrofit)
    implementation(MoshiLibs.moshiKotlin)

    implementation(Network.gson)
    implementation(Network.gsonRetrofit)


    implementation(Network.retrofit)
    implementation(Network.okHttp)
    implementation(Network.okHttpLogging)

    implementation(Network.paging)

}
