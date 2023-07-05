package com.itp.dailydrama;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

//step 1:  create a class as a child of RecyclerView.Adapter.
public class MyNewsListAdapter extends RecyclerView.Adapter<MyNewsListAdapter.MyArticleHolder> {

    //    ArrayList<News> list=new ArrayList<>();
    List<Article> articles;
    Context context;
//    ProgressBar progressBar;
//    ImageView news_image;
//    TextView news_title, news_description;


    public MyNewsListAdapter( Context context,List<Article> articles) {
        this.articles = articles;
        this.context = context;
    }
//    NewsItemClicked listener=null;

    @NonNull
    @Override
    public MyArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflator class is used to convert your XMl view into View Object

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card_design, parent, false);
        MyArticleHolder holder = new MyArticleHolder(view);

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                   listener.onClicked(list.get(holder.getAdapterPosition()));
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyNewsListAdapter.MyArticleHolder holder, int position) {

        Article article = articles.get(position);
        holder.progressbar.setVisibility(View.VISIBLE);
        holder.newsTitle.setText(article.getTitle());
        holder.newsDescription.setText(article.getDescription());
        Glide.with(context).load(article.getUrlToImage()).addListener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                holder.progressbar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                holder.progressbar.setVisibility(View.GONE);
                return false;
            }
        }).into(holder.newsImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, article.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("URL", article.getUrl());
                context.startActivity(intent);
            }
        });
    }

            @Override
            public int getItemCount() {
            return articles.size();
        }


            public class MyArticleHolder extends RecyclerView.ViewHolder {

                ImageView newsImage;
                TextView newsTitle;
                TextView newsDescription;
                ProgressBar progressbar;

                public MyArticleHolder(@NonNull View itemView) {
                    super(itemView);
                    newsImage = itemView.findViewById(R.id.news_image);
                    newsTitle = itemView.findViewById(R.id.news_title);
                    newsDescription = itemView.findViewById(R.id.news_description);
                    progressbar = itemView.findViewById(R.id.progressBar_item_layout);

                }
            }

        }



////step 2: create a your own holder class as a child of RecyclerView.ViewHolder
//
//
//interface NewsItemClicked
//{
//    void onClicked(News item);
//}
//
