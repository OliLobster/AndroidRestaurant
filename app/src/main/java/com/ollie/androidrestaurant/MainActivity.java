package com.ollie.androidrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements RestaurantListFragment
        .OnItemSelectListener {

    private RestaurantListFragment mListFragment;
    private RestaurantGridFragment mGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 /*       // Get ListView object from xml.
        ListView eventListView = (ListView) findViewById(R.id.event_list);

        // Assign adapter to ListView.
        RestaurantAdapter adapter = new RestaurantAdapter(this);

        eventListView.setAdapter(adapter);*/
        //add list view
        mListFragment = new RestaurantListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.restaurant_list_container,
                mListFragment).commit();


        //add Gridview
        if (isTablet()) {
            mGridFragment = new RestaurantGridFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.restaurant_grid_container,
                    mGridFragment).commit();
        }

    }
    // Add this method to main activity
    @Override
    public void onItemSelected(int position){
        mGridFragment.onItemSelected(position);
    }


    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
