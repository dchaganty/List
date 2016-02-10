package com.example.deepa.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.RelativeLayout;


public class InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        Intent intent = getIntent();
        String title = intent.getStringExtra(MainActivity.TITLE_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(title);

        TextView titleView = (TextView) findViewById(R.id.list_item_name);
        titleView.setText("Title: " + title);

//        RelativeLayout layout = (RelativeLayout) findViewById(R.id.detail_layout);
 //       layout.addView(textView);


    }




}
