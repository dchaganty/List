package com.example.deepa.list;

import android.app.LauncherActivity;
import android.app.ListActivity;
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

    private ArrayList<String> titleList;
    private ArrayList<String> infoList;
    private ArrayList<Boolean> completedList;
    public final static String INDEX_MESSAGE = "com.example.deepa.list.INDEX_MESSAGE";

    public ListView theListView;

    /*
    public void onClick(View v) {
        Toast toast = Toast.makeText(this, "hello",Toast.LENGTH_SHORT );
    }
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListData.initializeListData();
        theListView = (ListView) findViewById(android.R.id.list);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        
        titleList = ListData.getTitleList();
        infoList = ListData.getInfoList();
        completedList = ListData.getCompletedList();

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_layout, R.id.list_item,
                titleList);
        //theListView.setAdapter(listAdapter);
        setListAdapter(listAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedPosition = "Clicked item #" + position;
                Toast toast = Toast.makeText(MainActivity.this, clickedPosition, Toast.LENGTH_SHORT);
                toast.show();

                Log.i("onItemClick", "I was clicked!");
                Intent intent = new Intent(MainActivity.this, InfoPage.class);
                String clickedText = (String) parent.getItemAtPosition(position);
                Log.i("clickedText", clickedText.getClass().toString());
                intent.putExtra(INDEX_MESSAGE, position);
                startActivity(intent);
            }
        });

    }

    public void showDetail(View view) {
        Toast toast = Toast.makeText(this, "hi", Toast.LENGTH_SHORT);
        Intent intent = new Intent(this, InfoPage.class);

        //TextView clickedView = (TextView)view;
        //view.getParent();
        //String clickedText = clickedView.getText().toString();
        //intent.putExtra(TITLE_MESSAGE, clickedText);

       // LauncherActivity.ListItem clickedView = (LauncherActivity.ListItem)view;

        TextView textview = (TextView) findViewById(R.id.list_item);
        String message = textview.getText().toString();
        intent.putExtra(INDEX_MESSAGE, message);
        startActivity(intent);

    }


}

