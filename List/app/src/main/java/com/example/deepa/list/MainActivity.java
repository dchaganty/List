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
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_layout, R.id.list_item,
                titleList);
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
                Log.i("onItemLongClick", "The item at index " + position + " was LONG clicked!");
                long pos = parent.getItemIdAtPosition(position);
                view.setBackgroundColor(Color.parseColor("#73e600"));
                return true;
            }
        });
    }

    // TODO: Remove this
    public void showDetail(View view) {
        Toast toast = Toast.makeText(this, "hi", Toast.LENGTH_SHORT);
        Intent intent = new Intent(this, InfoPage.class);

        TextView textview = (TextView) findViewById(R.id.list_item);
        String message = textview.getText().toString();
        intent.putExtra(INDEX_MESSAGE, message);
        startActivity(intent);

    }


}

