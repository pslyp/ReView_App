package com.pslyp.reviewapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://pilot.cp.su.ac.th/usr/u07580536/yhinyhang/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if(mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Req Req() {
        return retrofit.create(Req.class);
    }

}
