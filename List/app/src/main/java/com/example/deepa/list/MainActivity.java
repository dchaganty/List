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
                Log.i("onItemLongClick", "Position: " + position + "id: " + id);
                boolean completed = ListData.getCompletedList().get(position);
                if (completed) {
                    ListData.setCompleted(position, false);
                    view.setBackgroundColor(Color.parseColor("#eeeeee"));
                } else {
                    ListData.setCompleted(position, true);
                    view.setBackgroundColor(Color.parseColor("#73e600"));
                }

                return true;
            }
        });


    }

    public void completeTask(View view) {
        TextView t = (TextView) view;
        int theId = t.getId();
        Log.i("POSITION", "" + theId);
//        String current = (String) t.getText();
//        if (current.equals("✓")) {
//            t.setText("DONE");
//            t.setTextColor(Color.parseColor("#73e600"));
//        }
//        else {
//            t.setText("✓");
//            t.setTextColor(Color.parseColor("#cccccc"));
//        }
    }


}

