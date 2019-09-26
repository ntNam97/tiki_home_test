package com.example.hometest.views;

import com.example.hometest.models.Keyword;

import java.util.List;

public interface KeywordView {

    void onGetKeywordsSuccess(List<Keyword> keywords);

    void onGetKeywordsFail(Throwable error);
}
