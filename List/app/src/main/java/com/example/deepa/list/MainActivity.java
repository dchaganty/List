package com.example.deepa.list;

import android.app.LauncherActivity;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    public ListView theListView;
    private ArrayList<String> titleList;
    private ArrayList<String> infoList;
    private ArrayList<Boolean> completedList;
    public final static String INDEX_MESSAGE = "com.example.deepa.list.INDEX_MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Initialize and set the content view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListData.initializeListData();

        // Store local reference to the ListView
        theListView = (ListView) findViewById(android.R.id.list);

        // Populate local ArrayLists
        titleList = ListData.getTitleList();
        infoList = ListData.getInfoList();
        completedList = ListData.getCompletedList();

        // Create adapter to dynamically pass strings to the view
        SpecialAdapter listAdapter = new SpecialAdapter(this, R.layout.list_layout, titleList);
        setListAdapter(listAdapter);

        // Set on click listener to generate an intent and launch new activity
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("onItemClick", "The item at index " + position + " was clicked!");
                String clickedText = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, InfoPage.class);
                intent.putExtra(INDEX_MESSAGE, position);
                startActivity(intent);
            }
        });

        // Set on click listener to generate an intent and launch new activity
        theListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("onItemLongClick", "Position: " + position + "id: " + id);
                boolean completed = ListData.getCompletedList().get(position);
                RelativeLayout l = (RelativeLayout)view;
                TextView v = (TextView)l.getChildAt(0);
                TextView w = (TextView)l.getChildAt(1);
                Log.i("Children", "v:" + v.getText().toString() + " w: " + w.getText().toString());
                if (completed) {
                    // Reset
                    ListData.setCompleted(position, false);
                    v.setTextColor(Color.BLACK);
                    w.setText("\u2705");
                    w.setTextColor(Color.LTGRAY);

                } else {
                    // Complete
                    ListData.setCompleted(position, true);
                    v.setTextColor(Color.LTGRAY);
                    w.setText("DONE!");
                    w.setTextColor(Color.parseColor("#73e600"));
                }
                return true;
            }
        });
    }
}

