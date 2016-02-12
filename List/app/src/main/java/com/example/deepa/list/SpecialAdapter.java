package com.example.deepa.list;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Matt Kauper on 2/12/16.
 */
public class SpecialAdapter extends ArrayAdapter<String> {

    public View v;

    // Constructor
    public SpecialAdapter(Context context,int layoutId, List<String> theList) {
        super(context, R.layout.list_layout, theList);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        this.v = convertView;

        // If this view hasn't existed before, inflate it
        if(v==null) {
            LayoutInflater vi = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=vi.inflate(R.layout.list_layout, null);
        }

        // Capture the labels in local variables
        TextView titleView = (TextView)v.findViewById(R.id.list_item);
        TextView completedView = (TextView)v.findViewById(R.id.completed);
        boolean isCompleted = ListData.getCompletedList().get(pos);

        // Update title text
        titleView.setText(getItem(pos));

        if(isCompleted) {
            // Format text: Completed!
            titleView.setTextColor(Color.LTGRAY);
            completedView.setText("DONE!");
            completedView.setTextColor(Color.parseColor("#73e600"));
        }
        else {
            // Format text: Incomplete!
            titleView.setTextColor(Color.BLACK);
            completedView.setText("\u2705");
            completedView.setTextColor(Color.LTGRAY);
        }

        return v;
    }
}
