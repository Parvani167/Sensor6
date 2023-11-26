package com.example.accelero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.text.Html;
import android.net.Uri;

public class Resources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        TextView yt = findViewById(R.id.yt);
//        yt.setTextColor("black");
        TextView as =findViewById(R.id.as);
//        as.setTextColor("black");
//        TextView link = findViewById(R.id.link3);

        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURl("https://www.youtube.com/watch?v=BVkfpygp0DM&pp=ygUVYWNjZWxlcm9tZXRlciBpbiBhbmRy");
            }
        });

        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURl("https://developer.android.com/codelabs/build-your-first-android-app#4");
            }
        });







    }

    private void gotoURl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}