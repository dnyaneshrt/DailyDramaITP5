package com.itp.dailydrama;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*


public interface NewsInterface {

    // @GET("top-headlines?country=in&category=entertainment&sortBy=popularity\n" +
    // "&apiKey=2357eef173f14e15bf0e7e14cb872630")

    //http://newsapi.org/v2/top-headlines?country=in&category=entertainment&sortBy=popularity
// &apiKey=2357eef173f14e15bf0e7e14cb872630

        const  BASE_URL = "https://newsapi.org/v2/"
        const  API_KEY = "2357eef173f14e15bf0e7e14cb872630"
    @GET("top-headlines?apiKey=$API_KEY")
    public Call<News> getHeadlines(
           String  @Query("country")country,
           int page @Query("page"),
           String category @Query("category"),
           String sortBy @Query("sortBy")
    );


}

class  NewService {
    NewsInterface newsInstance;

    {

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
*/
