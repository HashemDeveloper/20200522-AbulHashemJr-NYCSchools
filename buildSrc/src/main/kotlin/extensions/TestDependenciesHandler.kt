package extensions

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addTestDependencies() {
    testImplementation(dependencies.TestDependencies.JUNIT)

    androidTestImplementation(dependencies.TestDependencies.ANDROID_JUNIT)
    androidTestImplementation(dependencies.TestDependencies.ANDROID_RUNNER)
    androidTestImplementation(dependencies.TestDependencies.ANDROIDX_ESPRESSO)

    testImplementation(dependencies.TestDependencies.ROBOLECTRIC)
    testImplementation(dependencies.TestDependencies.ROBOLECTRIC_MULTIDEX)
}