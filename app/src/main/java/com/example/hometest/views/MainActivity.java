package com.example.hometest.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hometest.R;
import com.example.hometest.adapters.KeywordAdapter;
import com.example.hometest.models.Keyword;
import com.example.hometest.presenters.KeywordPresenter;
import com.example.hometest.presenters.KeywordPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements KeywordView {

    private RecyclerView rvKeyword;
    private KeywordAdapter adapter;
    private List<Keyword> mKeywords;

    private ProgressDialog progressDialog;

    private KeywordPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKeyword = findViewById(R.id.rvKeyword);

        progressDialog = new ProgressDialog(this);
        progressDialog.show();

        mKeywords = new ArrayList<>();

        mPresenter = new KeywordPresenterImpl(this);
        mPresenter.getKeywords();

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        adapter = new KeywordAdapter(mKeywords, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        rvKeyword.setLayoutManager(layoutManager);
        rvKeyword.setAdapter(adapter);
    }

    @Override
    public void onGetKeywordsSuccess(List<Keyword> keywords) {
        mKeywords.clear();
        mKeywords.addAll(keywords);
        adapter.notifyDataSetChanged();

        progressDialog.dismiss();
    }

    @Override
    public void onGetKeywordsFail(Throwable error) {
        Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_LONG).show();
        Log.d(MainActivity.class.getSimpleName(), "Error when load keyword list from server: " + error.getMessage());

        progressDialog.dismiss();
    }
}
