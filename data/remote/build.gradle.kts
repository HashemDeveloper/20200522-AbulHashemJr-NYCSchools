
import dependencies.DebugTools
import dependencies.AnnotationProcessor
import dependencies.Dependencies
import extensions.addTestDependencies

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
    }
    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }
    dexOptions {
        javaMaxHeapSize = "4g"
    }
    dataBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    androidExtensions {
        isExperimental = true
    }
    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(BuildModules.MODELS))
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.AndroidX.Core_KTX)

    addTestDependencies()

    implementation(Dependencies.Dagger.ANDROID)
    implementation(Dependencies.Dagger.ANDROID_SUPPORT)
    implementation(Dependencies.Retrofit.CORE)
    implementation(Dependencies.Retrofit.CONVERTER)
    implementation(Dependencies.Retrofit.RX_JAVA2)

    implementation(Dependencies.RxJava2.ANDROID_VERSION)
    implementation(Dependencies.RxJava2.JAVA_VERSION)

    compileOnly(AnnotationProcessor.Dagger.INJECT_ANNOTATION)
    kapt(AnnotationProcessor.Dagger.COMPILER)
    kapt(AnnotationProcessor.Dagger.ANDROID_PROCESSOR)
    kapt(AnnotationProcessor.Dagger.INJECT_PROCESSOR)

    implementation(Dependencies.LiveData.LIVE_DATA)
    implementation(Dependencies.LiveData.LIFECYCLE_SCOPE)
    implementation(Dependencies.LiveData.LIFECYCLE_COMMON)

    implementation(Dependencies.ViewModel.VIEW_MODEL_SAVE_STATE)

    implementation(Dependencies.PAGINATION.CORE)
    implementation(Dependencies.PAGINATION.RX_JAVA2)

    implementation(DebugTools.TIMBER)
    implementation(DebugTools.TIMBER)
    implementation(DebugTools.THREE_TEN)
    implementation(DebugTools.Stetho.STETHO)
    implementation(DebugTools.Stetho.OK_HTTP3)
}


