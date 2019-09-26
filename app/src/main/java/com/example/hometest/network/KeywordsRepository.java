package com.example.hometest.network;

import com.example.hometest.callback.KeywordCallback;

public interface KeywordsRepository {

    void getKeywords(KeywordCallback callback);
}
