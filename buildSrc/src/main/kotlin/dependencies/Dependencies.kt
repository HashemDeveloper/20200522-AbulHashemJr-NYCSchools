package dependencies

object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"
    const val MATERIAL_DESIGN = "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL_DESIGN_V}"
    const val EVENT_BUS = "org.greenrobot:eventbus:${BuildDependenciesVersions.EVENT_BUS_V}"
    const val CIRCULAR_IMAGE = "de.hdodenhof:circleimageview:${BuildDependenciesVersions.CIRCULAR_IMAGE_V}"
    const val MULTIDEX = "androidx.multidex:multidex:${BuildDependenciesVersions.MULTI_DEX_V}"
    const val FLOWABLE_TEXTVIEW = "com.github.deano2390:FlowTextView:${BuildDependenciesVersions.FLOWABLE_TEXTVIEW_V}"
    const val GOOGLE_MAP = "com.google.android.gms:play-services-maps:${BuildDependenciesVersions.GOOGLE_PLAY_SERVICE_AUTH}"

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.ANDROIDX_APPCOMPAT}"
        const val Core_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.ANDROIDX_CORE_KTX_V}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.ANDROIDX_CONSTRAINT_LAYOUT_V}"
        const val DESIGN_SUPPORT_LIB = "androidx.legacy:legacy-support-core-utils:${BuildDependenciesVersions.DESIGN_SUPPORT_LIB}"
        const val LEGACY = "androidx.legacy:legacy-support-v4:${BuildDependenciesVersions.ANDROIDX_LEGACY_V}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${BuildDependenciesVersions.ANDROID_FRAGMENT_KTX_V}"
    }
    object Retrofit {
        const val CORE = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.RETROFIT}"
        const val CONVERTER = "com.squareup.retrofit2:converter-gson:${BuildDependenciesVersions.GSON_V}"
        const val RX_JAVA2 = "com.squareup.retrofit2:adapter-rxjava2:${BuildDependenciesVersions.RETROFIT}"
    }
    object Dagger {
        const val ANDROID = "com.google.dagger:dagger-android:${BuildDependenciesVersions.DAGGER}"
        const val ANDROID_SUPPORT = "com.google.dagger:dagger-android-support:${BuildDependenciesVersions.DAGGER}"
    }
    object Room {
        const val RUNTIME = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM_V}"
        const val KTX = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM_V}"
    }
    object Coroutine {
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.KOTLIN_COROUTINES_V}"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.KOTLIN_COROUTINES_V}"
    }
    object RxJava2 {
        const val ANDROID_VERSION = "io.reactivex.rxjava2:rxandroid:${BuildDependenciesVersions.RX_ANDROID_V}"
        const val JAVA_VERSION = "io.reactivex.rxjava2:rxjava:${BuildDependenciesVersions.RX_JAVA_V}"
    }
    object ViewModel {
        const val VIEW_MODEL_LIFECYCLE_EXT = "androidx.lifecycle:lifecycle-extensions:${BuildDependenciesVersions.LIFECYCLE_VIEWMODEL_KTX_V}"
        const val VIEW_MODEL_LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE_VIEWMODEL_KTX_V}"
        const val VIEW_MODEL_SAVE_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${BuildDependenciesVersions.VIEW_MODEL_SAVED_STATE_V}"
        const val VIEW_MODEL_SCOPE = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.COROUTINE_SCOPE}"

    }
    object LiveData {
        const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${BuildDependenciesVersions.LIFECYCLE_VIEWMODEL_KTX_V}"
        const val LIFECYCLE_SCOPE = "androidx.lifecycle:lifecycle-runtime-ktx:${BuildDependenciesVersions.COROUTINE_SCOPE}"
        const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${BuildDependenciesVersions.COROUTINE_SCOPE}"
    }
    object Glide {
        const val CORE = "com.github.bumptech.glide:glide:${BuildDependenciesVersions.GLIDE}"
        const val TRANSFORMATION = "jp.wasabeef:glide-transformations:${BuildDependenciesVersions.GLIDE_TRANSFORMATION}"
        const val OKHTTP_INTEGRATION = "com.github.bumptech.glide:okhttp3-integration:${BuildDependenciesVersions.GLIDE_OKHTTP_INTEGRATION}"
    }
    object Navigation {
        const val FRAGMENT = "androidx.navigation:navigation-fragment:${BuildDependenciesVersions.NAVIGATION_V}"
        const val UI = "androidx.navigation:navigation-ui:${BuildDependenciesVersions.NAVIGATION_V}"
        const val FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION_V}"
        const val UI_KTX = "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION_V}"
    }
    object PAGINATION {
        const val RX_JAVA2 = "androidx.paging:paging-rxjava2:${BuildDependenciesVersions.PAGINATION}"
        const val CORE = "androidx.paging:paging-runtime:${BuildDependenciesVersions.PAGINATION}"
    }
}