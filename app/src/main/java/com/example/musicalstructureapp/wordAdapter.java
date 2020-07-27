package com.example.musicalstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter {


    public wordAdapter(Activity context, ArrayList<word> items) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, items);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        word currentword = (word) getItem(position);

        // Find the TextView in the item.xml layout with the ID version_name
        TextView name = (TextView) listItemView.findViewById(R.id.name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView

        name.setText(currentword.getName());

        // Find the TextView in the item.xml layout with the ID version_number
        TextView number = (TextView) listItemView.findViewById(R.id.number);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        number.setText(currentword.getArtist());


        return listItemView;


    }
}
