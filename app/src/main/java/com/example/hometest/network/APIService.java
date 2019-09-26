package com.example.hometest.network;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/tikivn/android-home-test/v2/keywords.json")
    Call<JsonArray> getKeywords();
}
