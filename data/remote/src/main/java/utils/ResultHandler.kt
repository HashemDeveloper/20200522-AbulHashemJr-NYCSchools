package utils

data class ResultHandler<out T>(val status: Status?=null, val data: T?=null, val message: String?=null) {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> onLoading(data: T?= null): ResultHandler<T> {
            return ResultHandler(
                Status.LOADING,
                data,
                null
            )
        }
        fun <T> onSuccess(data: T): ResultHandler<T> {
            return ResultHandler(
                Status.SUCCESS,
                data,
                null
            )
        }
        fun <T> onError(message: String, data: T?= null): ResultHandler<T> {
            return ResultHandler(
                Status.ERROR,
                data,
                message
            )
        }
    }
}