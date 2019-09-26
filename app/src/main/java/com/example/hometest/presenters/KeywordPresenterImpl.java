package com.example.hometest.presenters;

import com.example.hometest.callback.KeywordCallback;
import com.example.hometest.models.Keyword;
import com.example.hometest.network.KeywordsRepository;
import com.example.hometest.views.KeywordView;

import java.util.List;

public class KeywordPresenterImpl implements KeywordPresenter {

    private KeywordView mView;

    public KeywordPresenterImpl(KeywordView mView) {
        this.mView = mView;
    }

    @Override
    public void getKeywords() {
        KeywordsRepository repository = KeywordsRepository.getInstance();
        repository.getKeywords(new KeywordCallback() {
            @Override
            public void onSuccess(List<Keyword> keywords) {
                mView.onGetKeywordsSuccess(keywords);
            }

            @Override
            public void onError(Throwable error) {
                mView.onGetKeywordsFail(error);
            }
        });
    }
}
