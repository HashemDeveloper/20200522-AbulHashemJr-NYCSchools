package dependencies

object TestDependencies {
    const val ANDROID_RUNNER = "androidx.test:runner:${BuildDependenciesVersions.Test.ANDROID_RUNNER}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${BuildDependenciesVersions.Test.ANDROID_JUNIT}"
    const val ANDROIDX_ESPRESSO = "androidx.test.espresso:espresso-core:${BuildDependenciesVersions.Test.ANDROIDX_ESPRESSO}"
    const val JUNIT = "junit:junit:${BuildDependenciesVersions.Test.JUNIT}"
    const val ROBOLECTRIC = "org.robolectric:robolectric:${BuildDependenciesVersions.Test.ROBOLECTRIC}"
    const val ROBOLECTRIC_MULTIDEX = "org.robolectric:shadows-multidex:${BuildDependenciesVersions.Test.ROBOLECTRIC_MULTIDEX}"
}