package com.webtomob.newsapp.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.webtomob.newsapp.model.DataWrapper;
import com.webtomob.newsapp.model.Feed;
import com.webtomob.newsapp.repository.HomeRepository;
import com.webtomob.newsapp.retrofit.HttpConstant;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    private HomeRepository homeRepository = new HomeRepository();

    private MutableLiveData<Feed> feedMutableLiveData;

    public LiveData<Feed> getNews() {
        feedMutableLiveData = new MutableLiveData<>();

        homeRepository.getNews(/*getVersionCheckParams(versionName),*/ HttpConstant.ApiFlags.GET_NEWS).observeForever(new Observer<DataWrapper>() {
            @Override
            public void onChanged(DataWrapper dataWrapper) {

                if (null != dataWrapper.getData()) {
                    //  success response
                    Feed feedResponse = (Feed) dataWrapper.getData();
                    processFeedResponse(feedResponse);
                } else {
                    //  handle API exceptions or failed requests
                }
            }
        });
        return feedMutableLiveData;
    }

    void processFeedResponse(Feed feedResponse) {
        feedMutableLiveData.postValue(feedResponse);
    }

    public LiveData<String> getText() {
        return mText;
    }
}