
import dependencies.AnnotationProcessor
import dependencies.Dependencies
import dependencies.DebugTools
import extensions.addTestDependencies

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.NAVIGATION_SAFE_ARGS)
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
        buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)
        multiDexEnabled = true

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }
    buildTypes {
        getByName(BuildTypes.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
        }

        getByName(BuildTypes.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }
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
    implementation(project(BuildModules.CORE))
    implementation(project(BuildModules.REMOTE_DATA))
    implementation(project(BuildModules.SCHOOL_LIST_PAGE))
    implementation(project(BuildModules.SCHOOL_DETAILS))
    
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.Core_KTX)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.DESIGN_SUPPORT_LIB)
    implementation(Dependencies.AndroidX.LEGACY)

    implementation(Dependencies.Navigation.FRAGMENT_KTX)
    implementation(Dependencies.Navigation.UI_KTX)

    implementation(Dependencies.MATERIAL_DESIGN)

    implementation(Dependencies.EVENT_BUS)

    implementation(Dependencies.CIRCULAR_IMAGE)

    implementation(Dependencies.MULTIDEX)

    addTestDependencies()

    implementation(Dependencies.Dagger.ANDROID)
    implementation(Dependencies.Dagger.ANDROID_SUPPORT)
    implementation(Dependencies.Retrofit.CORE)
    implementation(Dependencies.Retrofit.CONVERTER)

    compileOnly(AnnotationProcessor.Dagger.INJECT_ANNOTATION)
    // for Java
    annotationProcessor(AnnotationProcessor.Dagger.COMPILER)
    annotationProcessor(AnnotationProcessor.Dagger.ANDROID_PROCESSOR)
    annotationProcessor(AnnotationProcessor.Dagger.INJECT_PROCESSOR)
    // for Kotlin
    kapt(AnnotationProcessor.Dagger.COMPILER)
    kapt(AnnotationProcessor.Dagger.ANDROID_PROCESSOR)
    kapt(AnnotationProcessor.Dagger.INJECT_PROCESSOR)

    implementation(DebugTools.TIMBER)
    implementation(DebugTools.TIMBER)
    implementation(DebugTools.THREE_TEN)
    implementation(DebugTools.Stetho.STETHO)
    implementation(DebugTools.Stetho.OK_HTTP3)
}
