package com.itp.dailydrama;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class Category_Activity extends AppCompatActivity {
    GridLayout mainGridayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        mainGridayout=findViewById(R.id.mainGridayout);
        setSingleEvent(mainGridayout);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        alertDialog.setTitle("Exit App!");
        alertDialog.setMessage("Do you really want to exit app?");
        alertDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == DialogInterface.BUTTON_POSITIVE) {

                    finish();

                }
            }
        });
        alertDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == DialogInterface.BUTTON_NEUTRAL) {
                    dialogInterface.dismiss();
                }
            }
        });
        alertDialog.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == DialogInterface.BUTTON_NEGATIVE) {
                    dialogInterface.dismiss();
                }

            }
        });
        alertDialog.show();
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
                                intent.putExtra("category", "entertainment");
                                startActivity(intent);

                            } else if (finalI == 1) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
                                intent.putExtra("category", "health");
                                startActivity(intent);

                            } else if (finalI == 2) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
                                intent.putExtra("category", "business");
                                startActivity(intent);

                            } else if (finalI == 3) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
                                intent.putExtra("category", "politics");
                                startActivity(intent);

                            } else if (finalI == 4) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
                                intent.putExtra("category", "science");
                                startActivity(intent);

                            } else if (finalI == 5) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
                                intent.putExtra("category", "sports");
                                startActivity(intent);

                            } else if (finalI == 6) {

                                Intent intent = new Intent(Category_Activity.this, MainActivity.class);
                                intent.putExtra("category", "technology");
                                startActivity(intent);

                            } else if (finalI == 7) {

//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Startups")
//                            startActivity(intent)
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();

                            } else if (finalI == 8) {


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Funny")
//                            startActivity(intent)
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();


                            } else if (finalI == 9) {
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","International")
//                            startActivity(intent)

                            } else if (finalI == 10) {
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Automobile")
//                            startActivity(intent)

                            } else if (finalI == 11) {
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Travel")
//                            startActivity(intent)

                            } else if (finalI == 12) {

                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();

//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Fashion")
//                            startActivity(intent)

                            } else if (finalI == 13) {
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();

// Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Education")
//                            startActivity(intent)

                            } else if (finalI == 14) {
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();

//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","India")
//                            startActivity(intent)

                            } else if (finalI == 15) {
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();


//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","Covid19")
//                            startActivity(intent)

                            } else if (finalI == 16) {
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();

//
//                            Intent intent = new Intent(Category_Activity.this, SettingsActivity.class);
//                            intent.putExtra("category","IPL2020")
//                            startActivity(intent)

                            } else if (finalI == 17) {
                                Toast.makeText(Category_Activity.this, "work in progress..", Toast.LENGTH_SHORT).show();

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
