package com.webtomob.newsapp.model;

public class DataWrapper<T> {
    private Throwable apiException;
    private T data;

    public Throwable getApiException() {
        return apiException;
    }

    public void setApiException(Throwable apiException) {
        this.apiException = apiException;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
