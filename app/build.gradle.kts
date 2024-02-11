plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.myfirstandroidapp.bookmark"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.myfirstandroidapp.bookmark"
        minSdk = 28
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
    dataBinding {
        enable = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    val roomVersion = "2.6.1"
// Room
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
// Room 코루틴
    implementation("androidx.room:room-ktx:$roomVersion")

    val lifecycleVersion = "2.3.0"
// ViewModel - 라이프 사이클
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
// LiveData - 데이터의 변경 사항을 알 수 있음
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

// 뷰모델 생성하기 쉽게 해줌
    implementation("androidx.fragment:fragment-ktx:1.1.0")

}