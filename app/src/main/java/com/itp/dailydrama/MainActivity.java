package com.itp.dailydrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    MyNewsListAdapter mAdapter;
     ArrayList<Article> articles = new ArrayList<>();
    int pageNum = 1;
    int totalResults = -1;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         recyclerView=findViewById(R.id.recyclerView);
         floatingActionButton=findViewById(R.id.floatingActionButton);

         LinearLayoutManager layoutManager=new LinearLayoutManager(this);

         //set layout Manager
         recyclerView.setLayoutManager(layoutManager);

    /*     ArrayList<String> dummyDataList=getDummyData();*/


         //passing data from activity to adapater
        mAdapter=new MyNewsListAdapter(this,articles);

         //setting the adapter to recyclerView
        recyclerView.setAdapter(mAdapter);


        try {
            fetchRealtimeNews();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                 Snackbar.make(view,"I am Floating action Button", Snackbar.LENGTH_LONG).setAction("Click me", new View.OnClickListener() {
//                     @Override
//                     public void onClick(View view) {
//                         Toast.makeText(MainActivity.this, "clicked on Click me!!", Toast.LENGTH_SHORT).show();
//                     }
//                 }).show();


                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"hey i have got this news from DailyDramaITP Entertainment android app.. "+articles.get(layoutManager.findFirstVisibleItemPosition()).getUrl());
                startActivity(Intent.createChooser(intent, "share this news using..."));

//    Snackbar.make(view, "coming soon...", Snackbar.LENGTH_LONG)
//    .setAction("Action", null).show()
            }
        });
    }

    private void fetchRealtimeNews() throws IllegalAccessException, InstantiationException {
        Toast.makeText(this, "make sure you have an internet connection", Toast.LENGTH_SHORT).show();

        String name = getIntent().getStringExtra("category");
        Call<News> news=NewService.class.newInstance().newsInstance.getHeadlines("in", pageNum, name, "popularity");
//        Call<News> news = NewService.newsInstance.getHeadlines("in", pageNum, name, "popularity")

news.enqueue(new Callback<News>() {
    @Override
    public void onResponse(Call<News> call, retrofit2.Response<News> response) {
        News mynews = response.body();

        if (mynews != null) {
//            progressBar_main.visibility = View.GONE

            Toast.makeText(MainActivity.this, "Swipe to see more", Toast.LENGTH_SHORT).show();

            Log.d("ifblock", response.body().toString());

            totalResults = mynews.getTotalResults();   //will get total count here

            articles.addAll(mynews.getArticles());

            mAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(MainActivity.this, "Getting nulll response", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<News> call, Throwable t) {
        Toast.makeText(MainActivity.this, "error in fetching news,check internet connection", Toast.LENGTH_SHORT).show();
    }
});

    }

 /*   private ArrayList<String> getDummyData()
    {
        ArrayList<String> list=new ArrayList<>();
        for(int i=1;i<=100;i++)
        {
            list.add("item :"+i);
        }
        return list;
    }*/

    //this method will get the real-time new using news api.
//    private void fetchRealtimeNews()
//    {
//        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=854c2a65868d4ed5a9d15f409b7fec16";
//
//        Log.d("calling URL",url);
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, response -> {
//
//
//                    JSONArray jsonArray= null;
//                    try {
//                        jsonArray = response.getJSONArray("articles");
//
//
//                    ArrayList<News> newsArray=new ArrayList<>();
//                         for(int i=0;i<jsonArray.length();i++)
//                         {
//                          JSONObject jsonObjet=jsonArray.getJSONObject(i);
//                             News news=new News(
//                                     jsonObjet.getString("title"),
//                                     jsonObjet.getString("description"),
//                                     jsonObjet.getString("url"),
//                                     jsonObjet.getString("urlToImage")
//                             );
//                             newsArray.add(news);
//                         }
//
//                        mAdapter.updateData(newsArray);
//                    } catch (JSONException e) {
//                        throw new RuntimeException(e);
//                    }
//                }, error -> {
//
//                    Toast.makeText(MainActivity.this, "failed to get response from api: "+error, Toast.LENGTH_SHORT).show();
//                    Log.d("api error",""+error);
//                });
//      /*  JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, response -> {
//
//                    try {
//                        JSONArray jsonArray= response.getJSONArray("articles");
//
//                        ArrayList<News> newsArray=new ArrayList<>();
//                        for(int i=0;i<jsonArray.length();i++)
//                        {
//                            JSONObject jsonObjet=jsonArray.getJSONObject(i);
//                            News news=new News(
//                                    jsonObjet.getString("title"),
//                                    jsonObjet.getString("description"),
//                                    jsonObjet.getString("url"),
//                                    jsonObjet.getString("urlToImage")
//                            );
//                            newsArray.add(news);
//                        }
//
//                        mAdapter.updateData(newsArray);
//
//                    } catch (JSONException e) {
//                        throw new RuntimeException(e);
//                    }
//                }, error -> {
//
//                    Toast.makeText(MainActivity.this, "failed to get response from api: "+error, Toast.LENGTH_SHORT).show();
//                    Log.d("api error",""+error);
//                });
//*/
//
//
//
//
//// Add the request to the RequestQueue.
//        queue.add(jsonObjectRequest);
//
//    }
//    @Override
//    public void onClicked(News item) {
//
//
//      /*  Intent intent= new Intent(this,DetailedActivity.class);
//        intent.putExtra("URL",art);
//        context?.startActivity(intent)  };
//*/
//}

}


