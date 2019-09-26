package com.example.hometest.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String BASE_URL = "https://raw.githubusercontent.com";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
