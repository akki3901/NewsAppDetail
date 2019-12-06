package com.webtomob.newsapp.base;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class BaseRepository {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(String baseUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor);

            client.networkInterceptors();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
        //            .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .client(client.build())
                    .build();
        }
        return retrofit;
    }
}
