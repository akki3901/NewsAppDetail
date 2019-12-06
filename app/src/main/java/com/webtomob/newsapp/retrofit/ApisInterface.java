package com.webtomob.newsapp.retrofit;

import com.webtomob.newsapp.model.Feed;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApisInterface {

    //@Headers("Content-Type: application/json")
    @GET(HttpConstant.NEWS_URL)
    Call<Feed> getNewsRequest();

    /*@Headers("Content-Type: application/json")
    @POST(HttpConstant.LOGOUT_URL)
    Call<ResponseBody> logoutRequest(@Body RequestBody body);*/

}