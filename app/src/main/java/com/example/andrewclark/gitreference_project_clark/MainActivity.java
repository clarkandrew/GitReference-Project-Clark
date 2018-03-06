package com.example.andrewclark.gitreference_project_clark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.io.InputStream;


/**
 * Created by andrewclark on 2/28/18.
 */


public class MainActivity extends AppCompatActivity {

    private boolean filteredState = false;
    private String jString;
    private ArrayList < GitReference > gitArray;
    private ListView referenceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referenceList = findViewById(R.id.reference_list);

        //gets json string from file and parses it
        getJsonString("GitReference.json");
        gitArray = JsonUtils.populateGitReferences(jString);

        //populates listview with json items
        final gitAdapter adapter = new gitAdapter(this, gitArray);
        referenceList.setAdapter(adapter);


        // long click to filter items by section, another long click to reset filter
        referenceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView < ? > adapterView, View view, int i, long l) {
                if (filteredState == true) {
                    // no filter
                    referenceList.setAdapter(adapter);
                    filteredState = false;
                } else {
                    String sectionFilter = referenceList.getItemAtPosition(i).toString();
                    gitArray = JsonUtils.filterGitReferences(jString, sectionFilter);
                    gitAdapter filteredAdapter = new gitAdapter(getApplicationContext(), gitArray);
                    referenceList.setAdapter(filteredAdapter);
                    //flip state
                    filteredState = true;
                    Toast.makeText(getApplicationContext(), getString(R.string.filter1) + " " + sectionFilter  + " " +  getString(R.string.filter2), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    // returns string of json file
    public String getJsonString(String filename) {
        InputStream iStream;
        try {
            iStream = getApplicationContext().getAssets().open(filename);
            jString = JsonUtils.parseJsonToString(iStream);
        } catch (Exception eMsg) {
            Log.i(getString(R.string.errMsg), eMsg.getMessage());
        }
        return jString;
    }
}