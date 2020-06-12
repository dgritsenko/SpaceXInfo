package com.dgricko.spacexinfo.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpaceInfoService {

    SpaceInfoApi api;

    public SpaceInfoService() {
        Retrofit retrofit = createRetrofit();
        api =retrofit.create(SpaceInfoApi.class);
    }

    public SpaceInfoApi getApi() {
        return api;
    }

    private Retrofit createRetrofit() {

        return new Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/v4/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient createOkHttpClient() {
        //Interceptor we can use if have some key or some variable

        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        return httpClient.build();
    }
}
