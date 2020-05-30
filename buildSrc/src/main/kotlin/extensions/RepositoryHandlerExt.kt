package extensions

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.maven

fun RepositoryHandler.applyDefault() {
    google()
    jcenter()
    mavenLocal()
    mavenCentral()
    maven ("https://jitpack.io")
    maven ("https://maven.google.com")
}