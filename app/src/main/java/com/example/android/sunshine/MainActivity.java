package com.example.android.sunshine;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        new MenuInflater(this).inflate(R.menu.main, menu);
        return (super.onCreateOptionsMenu(menu));
    }

    /**
     *  A Placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Creating fake list of forecast status to test the adapter
            String[] forecastArray = {
                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/40",
                    "Weds - Cloudy - 72/63",
                    "Thurs - Asteroids - 75/65",
                    "Fri - Heavy Rain - 65/56",
                    "Sat - Help Trapped In Weatherstaltion - 60/51",
                    "Sun - Sunny - 81/68"
            };

            // converting the array of string to list
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

            // ArrayAdapter will take the data from a the list and create the the ListView items
            mForecastAdapter = new ArrayAdapter<String>(
                    // getting the current context
                    getActivity(),
                    // id of list item item layout
                    R.layout.list_item_forecast,
                    // id of the text view to populate
                    R.id.list_item_forecast_textview,
                    // List of forecast status
                    forecastArray
            );

            // getting the root view (fragment_main Layout)
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // get a refrance to ListView
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);

            // attach adapter to listview
            listView.setAdapter(mForecastAdapter);
            
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
}
