package com.example.hometest.network;

import com.example.hometest.callback.KeywordCallback;
import com.example.hometest.models.Keyword;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KeywordsRepository {

    private static volatile KeywordsRepository keywordsRepository;
    private APIService apiService;

    public static KeywordsRepository getInstance() {
        if (keywordsRepository == null) {
            synchronized (KeywordsRepository.class) {
                if (keywordsRepository == null) {
                    keywordsRepository = new KeywordsRepository();
                }
            }
        }
        return keywordsRepository;
    }

    private KeywordsRepository() {
        apiService = RetrofitService.createService(APIService.class);
    }

    public void getKeywords(final KeywordCallback callback) {
        final List<Keyword> keywords = new ArrayList<>();
        apiService.getKeywords().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful()) {

                    JsonArray jsonArray = response.body();
                    if (jsonArray != null) {
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JsonElement jsonElement = jsonArray.get(i);
                            keywords.add(new Keyword(jsonElement.getAsString()));
                        }
                    }
                    callback.onSuccess(keywords);

                }

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

}
