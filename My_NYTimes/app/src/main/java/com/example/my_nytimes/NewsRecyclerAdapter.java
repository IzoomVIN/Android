package com.example.my_nytimes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {
    private final List<NewsItem> news;
    private final Context context;
    private final LayoutInflater inflater;
    private final ItemClickedCallback itemClickedCallback;

    NewsRecyclerAdapter(Context context, List<NewsItem> news, ItemClickedCallback callback) {
        this.news = news;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        itemClickedCallback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(
                this.inflater.inflate(R.layout.news_layout, parent, false),
                itemClickedCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsItem newsItem = this.news.get(position);
        Date diffDateToday = new Date();
        diffDateToday = new Date(diffDateToday.getTime() - newsItem.getPublishDate().getTime());
        holder.bind(newsItem, diffDateToday, context);
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView category;
        final TextView title;
        final TextView text;
        final TextView date;
        private NewsItem newsItem;

        ViewHolder(@NonNull View itemView, final ItemClickedCallback itemClickedCallback) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.category = itemView.findViewById(R.id.category);
            this.title = itemView.findViewById(R.id.title);
            this.text = itemView.findViewById(R.id.text);
            this.date = itemView.findViewById(R.id.date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickedCallback.onItemClicked(newsItem);
                }
            });
        }

        void bind(NewsItem item, Date diffDate, Context context) {
            this.category.setText(item.getCategory().getName());
            this.title.setText(item.getTitle());
            this.text.setText(item.getPreviewText());
            this.date.setText(diffDate.toString());
            this.newsItem = item;
            Glide.with(context).load(item.getImageUrl()).into(this.imageView);
        }


    }
}
