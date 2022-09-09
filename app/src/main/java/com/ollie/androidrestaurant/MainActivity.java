package com.ollie.androidrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
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
        // Show different fragments based on screen size.
        if (findViewById(R.id.fragment_container) != null) {
            Fragment fragment = isTablet() ? new RestaurantGridFragment()
                    : new RestaurantListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                    fragment).commit();
        }
    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
