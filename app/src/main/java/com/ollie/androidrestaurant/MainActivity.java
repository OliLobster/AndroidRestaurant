package com.ollie.androidrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements RestaurantListFragment
        .OnItemSelectListener, RestaurantGridFragment.OnItemSelectListener {

    private RestaurantListFragment mListFragment;
    private RestaurantGridFragment mGridFragment;
    private BackendListFragment mBackendFragment;

    @Override
    public void onListItemSelected(int position) {
        mListFragment.onItemSelected(position);
    }

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
        mBackendFragment = new BackendListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.restaurant_list_container,
                mBackendFragment).commit();


        //add Gridview

    }
    // Add this method to main activity
    @Override
    public void onItemSelected(int position){
        //start another activity if current device is phone
        if (!isTablet()) {
            Intent intent = new Intent(this, EventGridActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        } else {
            mGridFragment.onItemSelected(position);
        }
    }


    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
