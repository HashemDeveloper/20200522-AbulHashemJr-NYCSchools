
import dependencies.DebugTools
import dependencies.AnnotationProcessor
import dependencies.Dependencies
import extensions.addTestDependencies

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.NAVIGATION_SAFE_ARGS)
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
    implementation(project(BuildModules.REMOTE_DATA))

    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.AndroidX.Core_KTX)

    addTestDependencies()

    implementation(Dependencies.Dagger.ANDROID)
    implementation(Dependencies.Dagger.ANDROID_SUPPORT)
    implementation(Dependencies.Retrofit.CORE)
    implementation(Dependencies.Retrofit.CONVERTER)
    implementation(Dependencies.Retrofit.RX_JAVA2)

    compileOnly(AnnotationProcessor.Dagger.INJECT_ANNOTATION)
    // for java
    annotationProcessor(AnnotationProcessor.Dagger.COMPILER)
    annotationProcessor(AnnotationProcessor.Dagger.ANDROID_PROCESSOR)
    annotationProcessor(AnnotationProcessor.Dagger.INJECT_PROCESSOR)
    // for kotlin
    kapt(AnnotationProcessor.Dagger.COMPILER)
    kapt(AnnotationProcessor.Dagger.ANDROID_PROCESSOR)
    kapt(AnnotationProcessor.Dagger.INJECT_PROCESSOR)

    implementation(Dependencies.Navigation.FRAGMENT)
    implementation(Dependencies.Navigation.UI)
    implementation(Dependencies.Navigation.FRAGMENT_KTX)
    implementation(Dependencies.Navigation.UI_KTX)

    implementation(Dependencies.ViewModel.VIEW_MODEL_SAVE_STATE)
    implementation(Dependencies.ViewModel.VIEW_MODEL_LIFECYCLE_EXT)
    implementation(Dependencies.ViewModel.VIEW_MODEL_LIFECYCLE_KTX)
    implementation(Dependencies.ViewModel.VIEW_MODEL_SCOPE)

    implementation(Dependencies.Glide.CORE)
    implementation(Dependencies.Glide.TRANSFORMATION)
    kapt(AnnotationProcessor.GLIDE)
    annotationProcessor(AnnotationProcessor.GLIDE)
    implementation(Dependencies.Glide.OKHTTP_INTEGRATION) {
        this.exclude("glide-parent")
    }

    implementation(DebugTools.TIMBER)
    implementation(DebugTools.TIMBER)
    implementation(DebugTools.THREE_TEN)
    implementation(DebugTools.Stetho.STETHO)
    implementation(DebugTools.Stetho.OK_HTTP3)
}
