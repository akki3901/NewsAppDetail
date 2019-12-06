package com.webtomob.newsapp.repository;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.webtomob.newsapp.base.BaseRepository;
import com.webtomob.newsapp.model.DataWrapper;
import com.webtomob.newsapp.model.Feed;
import com.webtomob.newsapp.retrofit.APICallback;
import com.webtomob.newsapp.retrofit.ApisInterface;
import com.webtomob.newsapp.retrofit.CallbackInterface;
import com.webtomob.newsapp.retrofit.HttpConstant;

import retrofit2.Call;
import retrofit2.Response;

/**
 *  Wrap Retrofit response into Generic Data Wrapper
 *  Return wrapped data in LiveData (LiveData<DataWrapper<T>>) to ViewModel/Interactor for processing
 *  ViewModel will return needed data to view (activity/fragment)
 */

public class HomeRepository extends BaseRepository implements CallbackInterface {

    private final MutableLiveData<DataWrapper> newsData = new MutableLiveData<>();
    private final DataWrapper<Feed> feedDataWrapper = new DataWrapper<>();

    public LiveData<DataWrapper> getNews(/*HashMap<String, Object> params,*/ @Nullable HttpConstant.ApiFlags apiFlags){

        Call<Feed> call = getRetrofitClient(HttpConstant.BASE_URL).create(ApisInterface.class).getNewsRequest();

        APICallback.ApiCallbackObject(this, call, apiFlags);

        return newsData;
    }

    @Override
    public LiveData<DataWrapper> onSuccess(Response<Feed> response, @Nullable HttpConstant.ApiFlags apiFlags) {
        assert apiFlags != null;
        switch (apiFlags){

            case GET_NEWS:
                Feed data = response.body();
                feedDataWrapper.setData(data);
                newsData.postValue(feedDataWrapper);
                return newsData;

            default:
                //  no flag, no data, return empty objects
                final MutableLiveData<DataWrapper> emptyLiveData = new MutableLiveData<>();
                /*final DataWrapper<VersionCheckResponse> emptyDataWrapper = new DataWrapper<>();
                emptyLiveData.postValue(emptyDataWrapper);*/
                return emptyLiveData;

        }
    }

    @Override
    public LiveData<DataWrapper> onError(Response response, @Nullable HttpConstant.ApiFlags apiFlags) {
        assert apiFlags != null;
        switch (apiFlags){

            case GET_NEWS:
                /*VersionCheckResponse data = (VersionCheckResponse) response.body();
                feedDataWrapper.setData(data);
                newsdata.postValue(feedDataWrapper);*/
                return newsData;

            default:
                //  no flag, no data, return empty objects
                final MutableLiveData<DataWrapper> emptyLiveData = new MutableLiveData<>();
                /*final DataWrapper<VersionCheckResponse> emptyDataWrapper = new DataWrapper<>();
                emptyLiveData.postValue(emptyDataWrapper);*/
                return emptyLiveData;
        }
    }

    @Override
    public LiveData<DataWrapper> onFailure(Throwable t, @Nullable HttpConstant.ApiFlags apiFlags) {
        assert apiFlags != null;
        switch (apiFlags) {

            case GET_NEWS:
//                final MutableLiveData<DataWrapper> versionCheckFail = new MutableLiveData<>();
//                final DataWrapper<VersionCheckResponse> feedDataWrapper = new DataWrapper<>();;
                /*feedDataWrapper.setApiException(t);
                newsdata.postValue(feedDataWrapper);*/
                return newsData;

            default:
                //  no flag, no data, return empty objects
                final MutableLiveData<DataWrapper> emptyLiveData = new MutableLiveData<>();
                /*final DataWrapper<VersionCheckResponse> emptyDataWrapper = new DataWrapper<>();
                emptyLiveData.postValue(emptyDataWrapper);*/
                return emptyLiveData;
        }
    }

    @Override
    public LiveData<DataWrapper> onUnauthorized(Response response) {
        //  logout

        //  no flag, no data, return empty objects
        final MutableLiveData<DataWrapper> emptyLiveData = new MutableLiveData<>();
        /*final DataWrapper<VersionCheckResponse> emptyDataWrapper = new DataWrapper<>();
        emptyLiveData.postValue(emptyDataWrapper);*/
        return emptyLiveData;
    }
}
