package utils;

import androidx.lifecycle.MutableLiveData;

public class ViewStatusLiveData<T> extends MutableLiveData<ViewState<T>> {
    public void postLoading() {
        postValue(new ViewState<T>().isLoading());
    }

    public void postSuccess(T data) {
        postValue(new ViewState<T>().onSuccess(data));
    }

    public void postError(String errorMessage) {
        postValue(new ViewState<T>().onError(errorMessage));
    }
}
