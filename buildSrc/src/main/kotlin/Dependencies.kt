const val kotlinVersion = "1.3.71"

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
    const val bulid = "29.0.3"
}

object BuildPlugins {

    private object Versions{
        const val buildToolsVersion = "3.6.2"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
}

object Kotlin{
    private object Versions{
        const val coroutinesVersion = "1.3.5"
    }
    const val  kotlinStd7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${kotlinVersion}"
    const val  coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"

}

object Support{

    private object Versions{
        const val supportLibraryVersion = "1.1.0"
        const val constraintLayoutVersion = "1.1.3"
        const val googleMaterialVersion = "1.0.0-rc01"
    }

    const val compat = "androidx.appcompat:appcompat:${Versions.supportLibraryVersion}"
    const val androidxCore = "androidx.core:core:${Versions.supportLibraryVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val design = "com.google.android.material:material:${Versions.googleMaterialVersion}"
    const val cardView = "androidx.cardview:cardview:${Versions.supportLibraryVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.supportLibraryVersion}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.1"
        const val espresso = "3.2.0"
    }
    const val junit4     = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object ArchComponent {
    private object Versions {
        const val archComponentVersion = "4.12"
    }
    //architecture comps
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime:${Versions.archComponentVersion}"
    const val lifecycleExtension =
        "androidx.lifecycle:lifecycle-extensions:${Versions.archComponentVersion}"
    const val lifecycleCompiler =
        "androidx.lifecycle:lifecycle-compiler:${Versions.archComponentVersion}"
}

object Network {
    private object Versions {
        const val retrofitVersion = "2.6.2"
        const val okHttpVersion = "4.2.2"
        const val pagingVersion = "1.0.1"
    }
    //network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:4.0.1}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
    const val paging = "android.arch.paging:runtime:${Versions.pagingVersion}"
}

object MoshiLibs {
    private object Versions {
        const val moshiVersion = "1.9.2"
        const val retrofitVersion = "2.6.2"
        const val koshiVersion = "2.2.3"
    }
    //moshi
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val moshiRetrofit = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    const val kotshi = "se.ansman.kotshi:api:${Versions.koshiVersion}"
    const val kotshiCompiler = "se.ansman.kotshi:compiler:${Versions.koshiVersion}"
}

object DaggerLibs {
    private object Versions {
        const val daggerVersion = "2.27"
    }
    //Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
}

object Ui {
    private object Versions {
        const val roundCardViewVersion = "1.0.0"
        const val bottomNavVersion = "2.1.0"
        const val circularImageView = "3.1.0"
        const val navigationComponentVersion = "2.3.0-alpha03"
        const val lottieVersion = "3.0.0"
        const val recyclerViewItemDecorationVersion = "1.0.0"
    }
    //Ui
    const val roundCardView =
        "com.github.captain-miao:optroundcardview:${Versions.roundCardViewVersion}"
    const val recyclerViewtemDecoration =
        "com.bignerdranch.android:simple-item-decoration:${Versions.recyclerViewItemDecorationVersion}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
    const val bottomBar = "com.aurelhubert:ahbottomnavigation:${Versions.bottomNavVersion}"
    const val circularImageView = "de.hdodenhof:circleimageview:${Versions.circularImageView}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponentVersion}"
    const val navigationUi =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponentVersion}"
}