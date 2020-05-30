package utils;

public class ViewState<T> {
    private StatusType statusType;
    private T data;
    private String errorMessage;

    ViewState<T> isLoading() {
        this.statusType = StatusType.LOADING;
        this.data = null;
        this.errorMessage = "";
        return this;
    }

    ViewState<T> onSuccess(T data) {
        this.statusType = StatusType.SUCCESS;
        this.data = data;
        this.errorMessage = "";
        return this;
    }

    ViewState<T> onComplete() {
        this.statusType = StatusType.COMPLETE;
        this.errorMessage = "";
        return this;
    }

    ViewState<T> onError(String error) {
        this.statusType = StatusType.ERROR;
        this.data = null;
        this.errorMessage = error;
        return this;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public T getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
