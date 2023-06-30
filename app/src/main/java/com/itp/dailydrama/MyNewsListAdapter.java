package com.itp.dailydrama;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

//step 1:  create a class as a child of RecyclerView.Adapter.
public class MyNewsListAdapter extends RecyclerView.Adapter<MyHolder> {

    ArrayList<News> list=new ArrayList<>();
    NewsItemClicked listener=null;
    MyNewsListAdapter(NewsItemClicked listener)
    {
     this.listener=listener;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflator class is used to convert your XMl view into View Object

        View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_design,parent,false);
        MyHolder holder=new MyHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   listener.onClicked(list.get(holder.getAdapterPosition()));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position)
    {
        holder.textView.setText(list.get(holder.getAdapterPosition()).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void updateData(ArrayList<News> news)
    {
        list.clear();
        list.addAll(news);

        notifyDataSetChanged();

    }

}


//step 2: create a your own holder class as a child of RecyclerView.ViewHolder
class MyHolder extends RecyclerView.ViewHolder
{
    TextView textView;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
         textView=itemView.findViewById(R.id.textView);
    }
}


interface NewsItemClicked
{
    void onClicked(News item);
}
