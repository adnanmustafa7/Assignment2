package com.example.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.lv1);
        searchView=(SearchView) findViewById(R.id.searchView);

        list= new ArrayList<> ();
        list.add("Software Requirement Engineering");
        list.add("Software design and architecture");
        list.add("Software Engineering");
        list.add("Object oriented analysis and design");
        list.add("Communication Skills");
        list.add("Object oriented Programming");
        list.add("Data Structure and Algorithm");
        list.add("Techno");
        list.add("CTechnical and Business Writing");
        list.add("Linear Algebra");
        list.add("Digital Image Processing");
        list.add("Professional Practices");
        list.add("Programming Fundamentals");
        list.add("Calculas");
        list.add("English");
        list.add("Introduction to Computing");
        list.add("DataBase");
        list.add("Operating System");
        list.add("Computer Architecture");
        list.add("Islamiyat");
        list.add("web application development");
        list.add("Android Application development");
        list.add("Data Communication and Network");
        list.add("Data Science");


        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override

            public boolean onQueryTextSubmit(String query) {

                adapter.getFilter().filter(query);
                if(adapter.getCount()==0) {

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Not Found",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }
}
