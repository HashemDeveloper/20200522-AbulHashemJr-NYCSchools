package dependencies

object DebugTools {
    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER_V}"
    const val THREE_TEN = "com.jakewharton.threetenabp:threetenabp:${BuildDependenciesVersions.THREE_TEN_APP_V}"
    object Stetho {
        const val STETHO = "com.facebook.stetho:stetho:${BuildDependenciesVersions.FB_STETHO}"
        const val OK_HTTP3 = "com.facebook.stetho:stetho-okhttp3:${BuildDependenciesVersions.FB_STETHO}"
    }
}