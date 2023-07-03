package com.itp.dailydrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class Category_Activity extends AppCompatActivity {
    GridLayout mainGridayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        mainGridayout=findViewById(R.id.mainGridayout);
        setSingleEvent(mainGridayout);
    }

    private void setSingleEvent(GridLayout mainGridayout) {
        {

            int i = 0;
            for (i = 0; i < mainGridayout.getChildCount(); i++) {
                CardView cardView = (CardView) mainGridayout.getChildAt(i);

                int finalI = i;
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        {
                            if (finalI == 0) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
//                                intent.putExtra("category", "entertainment");
                                startActivity(intent);

                            } else if (finalI == 1) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
//                                intent.putExtra("category", "health");
                                startActivity(intent);

                            } else if (finalI == 2) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
//                                intent.putExtra("category", "business");
                                startActivity(intent);

                            } else if (finalI == 3) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
//                                intent.putExtra("category", "politics");
                                startActivity(intent);

                            } else if (finalI == 4) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
//                                intent.putExtra("category", "science");
                                startActivity(intent);

                            } else if (finalI == 5) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
//                                intent.putExtra("category", "sports");
                                startActivity(intent);

                            } else if (finalI == 6) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
                                intent.putExtra("category", "technology");
                                startActivity(intent);

                            } else if (finalI == 7) {

//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Startups")
//                            startActivity(intent)

                            } else if (finalI == 8) {


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Funny")
//                            startActivity(intent)

                            } else if (finalI == 9) {


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","International")
//                            startActivity(intent)

                            } else if (finalI == 10) {


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Automobile")
//                            startActivity(intent)

                            } else if (finalI == 11) {


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Travel")
//                            startActivity(intent)

                            } else if (finalI == 12) {


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Fashion")
//                            startActivity(intent)

                            } else if (finalI == 13) {

//
//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Education")
//                            startActivity(intent)

                            } else if (finalI == 14) {

//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","India")
//                            startActivity(intent)

                            } else if (finalI == 15) {


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Covid19")
//                            startActivity(intent)

                            } else if (finalI == 16) {

//
//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","IPL2020")
//                            startActivity(intent)

                            } else if (finalI == 17) {

//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Miscellaneous")
//                            startActivity(intent)

                            }
                        }
                    }
                });

            }
        }
    }
}
