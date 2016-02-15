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
import android.widget.CheckBox;
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
                Log.i("Item Click", "Position: " + position + "id: " + id);
                String clickedText = (String) parent.getItemAtPosition(position);
                ListData.setIndexLastClicked(position);
                Intent intent = new Intent(MainActivity.this, InfoPage.class);
                intent.putExtra(INDEX_MESSAGE, position);
                startActivity(intent);
            }
        });

        // Long click listener used to complete/reset items from the main list view
        theListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Item Long Click", "Position: " + position + "id: " + id);
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

    @Override
    public void onResume() {
        super.onResume();

        // Format the most recently clicked item upon returning from info page
        if (ListData.indexLastClicked != 99) {
            int idx = ListData.indexLastClicked;
            RelativeLayout lastClicked = (RelativeLayout) theListView.getChildAt(ListData.indexLastClicked - theListView.getFirstVisiblePosition());
            TextView v = (TextView)lastClicked.getChildAt(0);
            TextView w = (TextView)lastClicked.getChildAt(1);
            boolean completed = ListData.getCompletedList().get(ListData.indexLastClicked);

            if (completed) {
                v.setTextColor(Color.LTGRAY);
                w.setText("DONE!");
                w.setTextColor(Color.parseColor("#73e600"));

            } else {
                v.setTextColor(Color.BLACK);
                w.setText("\u2705");
                w.setTextColor(Color.LTGRAY);
            }
        }
    }

}

