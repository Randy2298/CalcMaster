package com.app.multicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity {

    private static final String VIDEO_URL = "https://www.youtube.com/embed/dRnE68ibmvc?si=YPOhdZcXtUCS9Gzm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        WebView webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(VIDEO_URL);

        // Bottom navigation
        RelativeLayout home = findViewById(R.id.home);
        RelativeLayout contact = findViewById(R.id.contact);
        RelativeLayout help = findViewById(R.id.help);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpActivity.this, "Home", Toast.LENGTH_SHORT).show();
                finish(); // Return to the previous activity
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                // Navigate to Contact activity
                Intent intent = new Intent(HelpActivity.this, Contact.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpActivity.this, "Help", Toast.LENGTH_SHORT).show();
                // Already on Help activity, no action needed
            }
        });
    }
}
