package extensions

import dependencies.Dependencies
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.commonFeaturesDependencies() {

    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.Core_KTX)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.DESIGN_SUPPORT_LIB)
    implementation(Dependencies.AndroidX.LEGACY)
    implementation(Dependencies.Navigation.FRAGMENT_KTX)
    implementation(Dependencies.AndroidX.FRAGMENT_KTX)
    implementation(Dependencies.Navigation.UI_KTX)
    implementation(Dependencies.MATERIAL_DESIGN)
    implementation(Dependencies.CIRCULAR_IMAGE)


    implementation(Dependencies.Dagger.ANDROID)
    implementation(Dependencies.Dagger.ANDROID_SUPPORT)
    implementation(Dependencies.Retrofit.CORE)
    implementation(Dependencies.Retrofit.CONVERTER)

    kapt(dependencies.AnnotationProcessor.Dagger.COMPILER)
    kapt(dependencies.AnnotationProcessor.Dagger.ANDROID_PROCESSOR)
    kapt(dependencies.AnnotationProcessor.Dagger.INJECT_PROCESSOR)
    kapt(dependencies.AnnotationProcessor.DATA_BINDING)

    implementation(Dependencies.LiveData.LIVE_DATA)
    implementation(Dependencies.LiveData.LIFECYCLE_SCOPE)
    implementation(Dependencies.LiveData.LIFECYCLE_COMMON)

    implementation(Dependencies.ViewModel.VIEW_MODEL_SAVE_STATE)
    implementation(Dependencies.ViewModel.VIEW_MODEL_LIFECYCLE_EXT)
    implementation(Dependencies.ViewModel.VIEW_MODEL_LIFECYCLE_KTX)
    implementation(Dependencies.ViewModel.VIEW_MODEL_SCOPE)

    implementation(dependencies.DebugTools.TIMBER)
    implementation(dependencies.DebugTools.TIMBER)
    implementation(dependencies.DebugTools.THREE_TEN)
    implementation(dependencies.DebugTools.Stetho.STETHO)
    implementation(dependencies.DebugTools.Stetho.OK_HTTP3)
}

fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)
fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)
fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)
fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)