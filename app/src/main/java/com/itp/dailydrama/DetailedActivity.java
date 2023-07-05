package com.itp.dailydrama;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class DetailedActivity extends AppCompatActivity {

    WebView detailedWebview;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        detailedWebview=findViewById(R.id.detailedWebview);
        progressBar=findViewById(R.id.progressBar2);

        String url=getIntent().getStringExtra("URL");
        if(url!=null) {
            detailedWebview.getSettings().setJavaScriptEnabled(true);
            detailedWebview.getSettings().setBuiltInZoomControls(true);

// detailedWebview.settings.userAgentString=""
//code to get the mobile website

            detailedWebview.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    progressBar.setVisibility(View.VISIBLE);
                    detailedWebview.setVisibility(View.VISIBLE);
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    return super.shouldOverrideUrlLoading(view, request);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    progressBar.setVisibility(View.GONE);
                    detailedWebview.setVisibility(View.VISIBLE);
                }

            });


            detailedWebview.loadUrl(url);

        }}
}