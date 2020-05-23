package dependencies

object AnnotationProcessor {
    const val DATA_BINDING = "com.android.databinding:compiler:${BuildDependenciesVersions.DATA_BINDING_COMPILER_V}"
    const val ROOM_PROCESSOR = "androidx.room:room-compiler:${BuildDependenciesVersions.ROOM_COMPILER_V}"
    const val GLIDE = "com.github.bumptech.glide:compiler:${BuildDependenciesVersions.GLIDE}"
    object Dagger {
        const val INJECT_ANNOTATION = "com.squareup.inject:assisted-inject-annotations-dagger2:${BuildDependenciesVersions.DAGGER_ASSISTED_INJECTION_V}"
        const val INJECT_PROCESSOR = "com.squareup.inject:assisted-inject-processor-dagger2:${BuildDependenciesVersions.DAGGER_ASSISTED_INJECTION_V}"
        const val ANDROID_PROCESSOR = "com.google.dagger:dagger-android-processor:${BuildDependenciesVersions.DAGGER}"
        const val COMPILER = "com.google.dagger:dagger-compiler:${BuildDependenciesVersions.DAGGER}"
    }
}
