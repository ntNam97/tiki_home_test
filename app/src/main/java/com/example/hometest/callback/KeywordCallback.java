package com.example.hometest.callback;

import com.example.hometest.models.Keyword;

import java.util.List;

public interface KeywordCallback {

    void onSuccess(List<Keyword> keywords);

    void onError(Throwable error);
}
