package com.example.todolistfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements ToDoListFragment.OnFragmentInteractionListener, NewItemFragment.OnNewItemAddedListener {

    // implements NewItemFragment.OnNewItemAddedListener
    private ArrayAdapter<String> aa;
    private ArrayList<String> todoItems;

    public void onNewItemAdded(String newItem){
        todoItems.add(newItem);
        aa.notifyDataSetChanged();
        Log.i("myLog", "MainActivity::onNewItemAdded " + newItem);
    }

    public void onFragmentInteraction(Uri uri) {
        Log.i("myLog", "MainActivity::onFragmentInteraction ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate your view
        setContentView(R.layout.activity_main);

        // Get references to the Fragments
        FragmentManager fm = getFragmentManager();
        /*
        ToDoListFragment todoListFragment;
        todoListFragment = (ToDoListFragment) fm.findFragmentById(R.id.ToDoListFragment);
        */

        Fragment fragment = fm.findFragmentById(R.id.ToDoListFragment);

        // Create the array list of to do items
        todoItems = new ArrayList<String>();

        // Create the array adapter to bind the array to the listview
        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                todoItems);

        // Bind the array adapter to the listview.
        // todoListFragment.setListAdapter(aa);
        ListView myListView = (ListView)findViewById(R.id.myListView);
        myListView.setAdapter(aa);
    }
}
