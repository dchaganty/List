package com.example.deepa.list;

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

public class MainActivity extends ListActivity implements View.OnClickListener {

    private ArrayList<String> todolist ;
    public final static String TITLE_MESSAGE = "com.example.deepa.list.TITLE_MESSAGE";
    public final static String INFO_MESSAGE = "com.example.deepa.list.INFO_MESSAGE";
    public ListView theListView;

    public void onClick(View v) {
        Toast toast = Toast.makeText(this, "hello",Toast.LENGTH_SHORT );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theListView = (ListView) findViewById(R.id.list_layout);
        String s = theListView.toString();
        Log.i("hi", s);

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        todolist = new ArrayList<String>();
        todolist.add("Number 1 ticket at Bodo's");
        todolist.add("Streak the lawn");
        todolist.add("Get a job");
        todolist.add("O'hill brunch");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");
        todolist.add("");


        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_layout, R.id.list_item,
                todolist);
        setListAdapter(listAdapter);

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
        TextView clickedView = (TextView)view;
        view.getParent();
        String clickedText = clickedView.getText().toString();
        // TextView textview = (TextView) findViewById(R.id.list_item);
        // String message = textview.getText().toString();
        intent.putExtra(TITLE_MESSAGE, clickedText);
        startActivity(intent);
        //Toast toast = Toast.makeText(this, "hello", Toast.LENGTH_SHORT);
        //toast.show();
    }
}
