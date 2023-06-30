package com.itp.dailydrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class MainActivity extends AppCompatActivity implements NewsItemClicked {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    MyNewsListAdapter mAdapter;

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

    /*     ArrayList<String> dummyDataList=getDummyData();*/


         //passing data from activity to adapater
        mAdapter=new MyNewsListAdapter(this);

         //setting the adapter to recyclerView
        recyclerView.setAdapter(mAdapter);
        fetchRealtimeNews();


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
    private void fetchRealtimeNews()
    {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=854c2a65868d4ed5a9d15f409b7fec16";

        Log.d("calling URL",url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {


                    JSONArray jsonArray= null;
                    try {
                        jsonArray = response.getJSONArray("articles");


                    ArrayList<News> newsArray=new ArrayList<>();
                         for(int i=0;i<jsonArray.length();i++)
                         {
                          JSONObject jsonObjet=jsonArray.getJSONObject(i);
                             News news=new News(
                                     jsonObjet.getString("title"),
                                     jsonObjet.getString("description"),
                                     jsonObjet.getString("url"),
                                     jsonObjet.getString("urlToImage")
                             );
                             newsArray.add(news);
                         }

                        mAdapter.updateData(newsArray);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }, error -> {

                    Toast.makeText(MainActivity.this, "failed to get response from api: "+error, Toast.LENGTH_SHORT).show();
                    Log.d("api error",""+error);
                });
      /*  JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {

                    try {
                        JSONArray jsonArray= response.getJSONArray("articles");

                        ArrayList<News> newsArray=new ArrayList<>();
                        for(int i=0;i<jsonArray.length();i++)
                        {
                            JSONObject jsonObjet=jsonArray.getJSONObject(i);
                            News news=new News(
                                    jsonObjet.getString("title"),
                                    jsonObjet.getString("description"),
                                    jsonObjet.getString("url"),
                                    jsonObjet.getString("urlToImage")
                            );
                            newsArray.add(news);
                        }

                        mAdapter.updateData(newsArray);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }, error -> {

                    Toast.makeText(MainActivity.this, "failed to get response from api: "+error, Toast.LENGTH_SHORT).show();
                    Log.d("api error",""+error);
                });
*/




// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);

    }
    @Override
    public void onClicked(News item) {

    }

}