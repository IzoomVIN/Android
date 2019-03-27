package com.example.my_nytimes;

import android.app.Activity;
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
    private final Activity activity;

    NewsRecyclerAdapter(Context context, List<NewsItem> news, Activity activity){
        this.news = news;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(
                this.inflater.inflate(R.layout.news_layout, parent, false),
                activity);
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

    static class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageView;
        final TextView category;
        final TextView title;
        final TextView text;
        final TextView date;
        private String imageURL;
        private String fullText;

        ViewHolder(@NonNull View itemView, final Activity activity) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.category = itemView.findViewById(R.id.category);
            this.title = itemView.findViewById(R.id.title);
            this.text = itemView.findViewById(R.id.text);
            this.date= itemView.findViewById(R.id.date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsInfoActivity.start(activity, imageURL, category.getText().toString(),
                            title.getText().toString(), date.getText().toString(),
                            fullText);
                }
            });
        }

        void bind(NewsItem item, Date diffDate, Context context){
            this.category.setText(item.getCategory().getName());
            this.title.setText(item.getTitle());
            this.text.setText(item.getPreviewText());
            this.date.setText(diffDate.toString());
            this.fullText = item.getFullText();
            this.imageURL = item.getImageUrl();

            Glide.with(context).load(imageURL).into(this.imageView);
        }


    }
}
