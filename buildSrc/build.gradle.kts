plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

object PluginVersions {
    const val GRADLE_ANDROID_VERSION = "3.6.3"
    const val GRADLE_VERSION = "0.28.0"
    const val KOTLIN_VERSION = "1.3.72"
    const val NAVIGATION = "2.2.1"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven ("https://jitpack.io")
    maven ("https://maven.google.com")
    google()
    jcenter()
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginVersions.GRADLE_ANDROID_VERSION}")
    implementation("com.github.ben-manes:gradle-versions-plugin:${PluginVersions.GRADLE_VERSION}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.KOTLIN_VERSION}")
    implementation("org.jetbrains.kotlin:kotlin-allopen:${PluginVersions.KOTLIN_VERSION}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${PluginVersions.NAVIGATION}")
}