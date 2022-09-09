package com.ollie.androidrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 /*       // Get ListView object from xml.
        ListView eventListView = (ListView) findViewById(R.id.event_list);

        // Assign adapter to ListView.
        RestaurantAdapter adapter = new RestaurantAdapter(this);

        eventListView.setAdapter(adapter);*/
    }
}
