package com.example.hometest.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hometest.R;
import com.example.hometest.models.Keyword;
import com.example.hometest.utils.ColorUtil;
import com.example.hometest.utils.DataUtil;

import java.util.List;

public class KeywordAdapter extends RecyclerView.Adapter<KeywordAdapter.KeywordViewHolder> {


    private List<Keyword> keywords;
    private Context mContext;

    public KeywordAdapter(List<Keyword> keywords, Context mContext) {
        this.keywords = keywords;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public KeywordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_keyword, parent, false);
        return new KeywordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeywordViewHolder holder, int position) {
        holder.txtKeyWord.setText(DataUtil.formatString(keywords.get(position).getKeyword()));
        GradientDrawable gradientDrawable = (GradientDrawable) holder.txtKeyWord.getBackground();
        gradientDrawable.setColor(mContext.getResources().getColor(ColorUtil.getColorItem(position)));
    }

    @Override
    public int getItemCount() {
        return keywords.size();
    }

    class KeywordViewHolder extends RecyclerView.ViewHolder {
        private TextView txtKeyWord;

        KeywordViewHolder(@NonNull View itemView) {
            super(itemView);
            txtKeyWord = itemView.findViewById(R.id.txtKeyword);
        }
    }
}
