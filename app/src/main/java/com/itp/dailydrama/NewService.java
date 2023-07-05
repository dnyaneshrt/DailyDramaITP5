package com.itp.dailydrama;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;



interface NewsInterface {

    // @GET("top-headlines?country=in&category=entertainment&sortBy=popularity\n" +
    // "&apiKey=2357eef173f14e15bf0e7e14cb872630")

    //http://newsapi.org/v2/top-headlines?country=in&category=entertainment&sortBy=popularity
// &apiKey=2357eef173f14e15bf0e7e14cb872630

    String  BASE_URL = "https://newsapi.org/v2/";
    String  API_KEY = "2357eef173f14e15bf0e7e14cb872630";
    @GET("top-headlines?apiKey="+API_KEY)
    public Call<News> getHeadlines(
            @Query("country") String  country,
            @Query("page") int page,
            @Query("category") String category ,
            @Query("sortBy") String sortBy
    );


}

public class  NewService {
    public NewsInterface newsInstance;
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(newsInstance.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsInstance = retrofit.create(NewsInterface.class);
    }
}
