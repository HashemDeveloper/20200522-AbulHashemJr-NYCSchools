interface BuildTypes {

    companion object {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }
    val isMinifyEnabled: Boolean
}
object BuildTypeDebug : BuildTypes {
    override val isMinifyEnabled = false
}

object BuildTypeRelease : BuildTypes {
    override val isMinifyEnabled = true
}