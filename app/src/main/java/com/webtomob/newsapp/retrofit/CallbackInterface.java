package com.webtomob.newsapp.retrofit;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.webtomob.newsapp.model.DataWrapper;
import com.webtomob.newsapp.model.Feed;

import retrofit2.Response;

public interface CallbackInterface {

    LiveData<DataWrapper> onSuccess(Response<Feed> response, @Nullable HttpConstant.ApiFlags apiFlags);

    LiveData<DataWrapper> onError(Response<Feed> response, @Nullable HttpConstant.ApiFlags apiFlags);

    LiveData<DataWrapper> onFailure(Throwable t, @Nullable HttpConstant.ApiFlags apiFlags);

    //  callback for invalid token
    LiveData<DataWrapper> onUnauthorized(Response response);
}
