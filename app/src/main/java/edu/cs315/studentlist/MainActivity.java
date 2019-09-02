package edu.cs315.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView simpleList;


    // comment code to trigger changes


    // Array of strings...
    String peopleList[] = {
            "Zack Albrecht",
            "Paula Berggren",
            "JC Campbell",
            "Yodeli Castillo",
            "Brady Cox",
            "Kelvin Crawford",
            "Adam Garcia",
            "Will Gibbs",
            "Jerry Guo",
            "Sarah Kathryn Hall",
            "Josh Kersker",
            "Ben Lamont",
            "Kyle Lemons",
            "Wade Linder",
            "Josh Marsden",
            "Felix Angelo Mbikogbia",
            "Mitchell Melrose",
            "Jade Rupley",
            "JD Schwiethale",
            "Anand Shah",
            "Rich Tanner",
            "Anna Ter Kuile",
            "Travis Towell",
            "Sam Webb",
            "Ruben Yanez"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      setContentView(R.layout.activity_main);
        simpleList = (ListView)findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, peopleList);
        simpleList.setAdapter(arrayAdapter);
        simpleList.setOnItemClickListener(this);  // set THIS class as the listener
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        // we got notified that something was selected!  AND we know WHICH ITEM was selected!

        // get the value of the string in the specific position of the array that was selected (tapped on)
        String personSelected = (String) simpleList.getAdapter().getItem(position);

        /** do something cool based on the INDEX (int) of the selected item **/
        switch (position) {
            case 20:
                // by specific index
                Toast.makeText(this, personSelected + " wrote some jank code!!", Toast.LENGTH_LONG).show();
                break;
            default:
                // every case that wasn't specifically called out
                Toast.makeText(this, personSelected + " selected", Toast.LENGTH_LONG).show();
                break;
        }

        /** do something cool based on the VALUE (string) of the selected item **/
        if (personSelected == "Rich Tanner") {
            // go to a new activity
            Context context = simpleList.getContext();
            Intent intent = new Intent(context, TannerActivity.class);
            context.startActivity(intent);
        }
    }
}
