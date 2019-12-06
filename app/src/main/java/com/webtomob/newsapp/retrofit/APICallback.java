package com.webtomob.newsapp.retrofit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.webtomob.newsapp.model.Feed;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APICallback {

    /**
     * new API callback methods
     *
     * @param callBackInterface
     * @param call
     * @param apiFlags
     */

    /*public static void ApiCallback(final CallbackInterface callBackInterface, Call<String> call, @Nullable final HttpConstant.ApiFlags apiFlags) {
        //  API call
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

                if (response.isSuccessful()) {
                    //  http code 200~300
                    try {
                        JSONObject jsonObject = new JSONObject(response.body());

                        if (jsonObject.getBoolean("success")) {
                            //  API call success
                            callBackInterface.onSuccess(response, apiFlags);
                        } else {
                            //  API call failed
                            callBackInterface.onError(response, apiFlags);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    //  http code > 300
                    callBackInterface.onUnauthorized(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    callBackInterface.onError(null , apiFlags);
                }
            }
        });
    }*/

    public static void ApiCallbackObject(final CallbackInterface callBackInterface, Call<Feed> call, @Nullable final HttpConstant.ApiFlags apiFlags) {
        //  API call
        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if (response.isSuccessful()) {
                    //  API call success
                    callBackInterface.onSuccess(response, apiFlags);

                } else {
                    //  http code > 300
                    callBackInterface.onUnauthorized(response);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    callBackInterface.onError(null , apiFlags);
                }
            }
        });
    }
}
