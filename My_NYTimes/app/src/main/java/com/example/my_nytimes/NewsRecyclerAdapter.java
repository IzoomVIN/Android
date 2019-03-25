package com.example.my_nytimes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {
    private final List<NewsItem> news;
    private final Context context;
    private final LayoutInflater inflater;

    public NewsRecyclerAdapter(Context context, List<NewsItem> news){
        this.news = news;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                this.inflater.inflate(R.layout.news_layout, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsItem newsItem = this.news.get(position);

        holder.category.setText(newsItem.getCategory().getName());
        holder.title.setText(newsItem.getTitle());
        holder.text.setText(newsItem.getPreviewText());
        holder.date.setText(newsItem.getPublishDate().toString());
        Glide.with(context).load(newsItem.getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        public final ImageView imageView;
        public final TextView category;
        public final TextView title;
        public final TextView text;
        public final TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.category = itemView.findViewById(R.id.category);
            this.title = itemView.findViewById(R.id.title);
            this.text = itemView.findViewById(R.id.text);
            this.date= itemView.findViewById(R.id.date);
        }
    }
}
