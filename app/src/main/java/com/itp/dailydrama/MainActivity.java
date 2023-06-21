package com.itp.dailydrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsItemClicked {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView=findViewById(R.id.recyclerView);
         floatingActionButton=findViewById(R.id.floatingActionButton);

         floatingActionButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Snackbar.make(view,"I am Floating action Button", Snackbar.LENGTH_LONG).setAction("Click me", new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Toast.makeText(MainActivity.this, "clicked on Click me!!", Toast.LENGTH_SHORT).show();
                     }
                 }).show();
             }
         });

         //set layout Manager
         recyclerView.setLayoutManager(new LinearLayoutManager(this));

         ArrayList<String> dummyDataList=getDummyData();

         //passing data from activity to adapater
         MyNewsListAdapter adapter=new MyNewsListAdapter(dummyDataList,this);
         //setting the adapter to recyclerView
         recyclerView.setAdapter(adapter);


    }

    private ArrayList<String> getDummyData()
    {
        ArrayList<String> list=new ArrayList<>();
        for(int i=1;i<=100;i++)
        {
            list.add("item :"+i);
        }
        return list;
    }

    @Override
    public void onClicked(String item) {
        Toast.makeText(this,"clicked on item: "+item,Toast.LENGTH_SHORT).show();
    }
}