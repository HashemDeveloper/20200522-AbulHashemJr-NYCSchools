
import dependencies.AnnotationProcessor
import dependencies.Dependencies
import extensions.addTestDependencies
import extensions.commonFeaturesDependencies

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
        resValue("string", "google_map_key", (project.findProperty("GOOGLE_MAP_KEY")?.toString() ?: ""))
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
    androidExtensions {
        isExperimental = true
    }
    dataBinding {
        isEnabled = true
    }
    viewBinding {
        isEnabled = true
    }
    dexOptions {
        javaMaxHeapSize = "4g"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(project(BuildModules.CORE))
    implementation(project(BuildModules.REMOTE_DATA))
    implementation(project(BuildModules.MODELS))
    implementation(project(BuildModules.ASSETS))
    implementation(Dependencies.Glide.TRANSFORMATION)
    kapt(AnnotationProcessor.GLIDE)
    implementation(Dependencies.Glide.OKHTTP_INTEGRATION) {
        this.exclude("glide-parent")
    }
    implementation(Dependencies.PAGINATION.CORE)
    implementation(Dependencies.FLOWABLE_TEXTVIEW)
    implementation(Dependencies.KOTLIN)
    addTestDependencies()
    commonFeaturesDependencies()
    compileOnly(AnnotationProcessor.Dagger.INJECT_ANNOTATION)
}
