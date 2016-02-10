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
        int index = intent.getIntExtra(MainActivity.INDEX_MESSAGE, 99);
        String title = ListData.getTitleList().get(index);
        String info = ListData.getInfoList().get(index);
        boolean completed = ListData.getCompletedList().get(index);

        TextView titleView = (TextView) findViewById(R.id.list_item_name);
        titleView.setText("Title: " + title);
        titleView.setTextSize(40);

        TextView infoView = (TextView) findViewById(R.id.list_item_info);
        infoView.setText("Info: " + info);
        infoView.setTextSize(24);

 //       RelativeLayout layout = (RelativeLayout) findViewById(R.id.detail_layout);
 //       layout.addView(textView);


    }




}
