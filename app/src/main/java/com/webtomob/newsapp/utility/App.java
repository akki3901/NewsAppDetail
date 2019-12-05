package com.webtomob.newsapp.utility;

import android.app.Application;
import android.content.Context;

import com.webtomob.newsapp.R;
import com.webtomob.newsapp.listener.BaseListener;
import com.webtomob.newsapp.retrofit.ApiClient;
import com.webtomob.newsapp.retrofit.ApiClientComponent;
import com.webtomob.newsapp.retrofit.ApisCallClass;
import com.webtomob.newsapp.retrofit.ApisInterface;
import com.webtomob.newsapp.retrofit.NetModule;
import com.webtomob.newsapp.retrofit.DaggerApiClientComponent;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;


public class App extends Application {
    private static App mInstance;
    public static boolean isDebuggable;
    private Retrofit retrofit;
    private ApiClient apiClient;
    private ApisInterface apiInterface;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        ApiClientComponent component = DaggerApiClientComponent.builder().netModule(new NetModule()).build();
        apiClient = component.provideRetrofit();
        retrofit = apiClient.getRetrofit();
        apiInterface = retrofit.create(ApisInterface.class);


        // Normal app init code...

    }

    public static App getInstance() {
        return mInstance;
    }

    /*public void getPermission(Context activityContext) {
        if (AppUtility.isInternetAvailable(activityContext) == false) {
            //showAlertDialog(this, getString(R.string.app_name), getString(R.string.no_internet));
            return;
        }

        JSONObject object = new JSONObject();
        try {
            object.put("locale", AppUtility.locale);
            object.put("token", mPreference.getString(PrefConstant.TOKEN_STR));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final Call<ResponseBody> request = retrofit.create(ApisInterface.class).getAccessRights(RequestBody.create(MediaType.parse("application/json"), object.toString()));

        ApisCallClass.commonRequest(false, activityContext, request, new BaseListener.OnWebServiceCompleteListener<String>() {
            @Override
            public void onWebServiceComplete(String baseObject) {
                //AppUtility.showLog("Access Rights  ", baseObject.toString());

                AccessRightResponseBean accessRightResponseBean = AppUtility.g.fromJson(baseObject, AccessRightResponseBean.class);

                if (accessRightResponseBean.getStatus().equals(AppUtility.successStatus)) {
                    EventBus.getDefault().post(accessRightResponseBean);
                    mPreference.putString(PrefConstant.ACCESS_RIGHTS, AppUtility.g.toJson(accessRightResponseBean.getResult(), AccessRightResult.class));

                } else {
                    if(AppUtility.isActivityRunning(App.class, getApplicationContext())) {showAlertDialog(activityContext, getString(R.string.app_name), accessRightResponseBean.getErrorMessage());
                }}
            }

            @Override
            public void onWebServiceError(String resultString) {
                if(AppUtility.isActivityRunning(App.class, getApplicationContext())) {showAlertDialog(activityContext, getString(R.string.app_name), resultString);
            }}
        });
    }*/

}