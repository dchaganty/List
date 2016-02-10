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

    private ArrayList<String> todolist ;
    public final static String TITLE_MESSAGE = "com.example.deepa.list.TITLE_MESSAGE";
    public final static String INFO_MESSAGE = "com.example.deepa.list.INFO_MESSAGE";
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
        //theListView = (ListView) findViewById(R.id.list_layout);
        //String s = theListView.toString();
        //Log.i("hi", s);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        todolist = new ArrayList<String>();
        todolist.add("Get the number 1 ticket at Bodo's");
        todolist.add("Streak the lawn");
        todolist.add("Paint beta bridge");
        todolist.add("O'hill brunch");
        todolist.add("Go to Trick or Treating on the Lawn");
        todolist.add("Go to a basketball game");
        todolist.add("Dress up in pearls/tie for a football game");
        todolist.add("Go inside the Rotunda");
        todolist.add("Sing the Good Ole Song");
        todolist.add("Have a picnic on the lawn");
        todolist.add("Attend Rotunda Sing");
        todolist.add("Go to Lighting of the Lawn");
        todolist.add("High-five Dean Groves");
        todolist.add("Pick apples at Carter's Mountain");
        todolist.add("Pull an all-nighter at Clem");
        todolist.add("Eat at Pancakes for Parkinson's");
        todolist.add("Volunteer through Madison House");
        todolist.add("Do a sunrise hike at Humpback Mountain");
        todolist.add("Visit Carr's Hill");
        todolist.add("Get a job");


        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_layout, R.id.list_item,
                todolist);
        setListAdapter(listAdapter);

        /*
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(MainActivity.this, InfoPage.class);
                TextView clickedView = (TextView) view;
                String clickedText = clickedView.getText().toString();
                // TextView textview = (TextView) findViewById(R.id.list_item);
                // String message = textview.getText().toString();
                intent.putExtra(TITLE_MESSAGE, clickedText);
                startActivity(intent);
            }
        });
        */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Toast toast = Toast.makeText(this, id, Toast.LENGTH_SHORT);
        toast.show();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        intent.putExtra(TITLE_MESSAGE, message);
        startActivity(intent);

    }
}
