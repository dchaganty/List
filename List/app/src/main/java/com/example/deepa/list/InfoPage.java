package com.example.deepa.list;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.widget.Toast;


public class InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        Intent intent = getIntent();
        int index = intent.getIntExtra(MainActivity.INDEX_MESSAGE, 99);

        // Get data from ListData
        String title = ListData.getTitleList().get(index);
        String info = ListData.getInfoList().get(index);
        boolean completed = ListData.getCompletedList().get(index);


        // Update title label
        TextView titleView = (TextView) findViewById(R.id.list_item_name);
        titleView.setText(title);

        // Update info label
        TextView infoView = (TextView) findViewById(R.id.list_item_info);
        infoView.setText(info);

        Button b = (Button) findViewById(R.id.the_button);
        if(completed) {
           b.setText("Done!");
        }
        else {
            b.setText("Complete Me!");
        }
        /*
        View.OnClickListener buttonListener = new View.OnClickListener() {
            boolean clicked = false;
            Intent intent = getIntent();
            int index = intent.getIntExtra(MainActivity.INDEX_MESSAGE, 99);
            boolean completed = ListData.getCompletedList().get(index);
            @Override
            public void onClick(View v) {
                if(completed) {
                    completed = !completed;
                    ListData.getCompletedList().set(index, completed);
                }
                else {
                    completed = !completed;
                    ListData.getCompletedList().set(index, completed);
                }
            }
        };
        b.setOnClickListener(buttonListener);
        */
 //       RelativeLayout layout = (RelativeLayout) findViewById(R.id.detail_layout);
 //       layout.addView(textView);

    }




}
