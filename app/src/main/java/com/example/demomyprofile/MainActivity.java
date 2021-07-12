package com.example.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGPA = findViewById(R.id.etGPA);
        etName = findViewById(R.id.etName);



    }

    @Override
    protected void onPause() {
        super.onPause();

        String gpa = etGPA.getText().toString();
        float fgpa = 0f;

        if (gpa.length() > 0) {
            fgpa = Float.parseFloat(gpa);
        }
        //Step 1a: Get the user input from the EditTect and store it in a variable
        String name = etName.getText().toString();

        // Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefsEdit = prefs.edit();

        // Step 1d: Add the key-value pair
        prefsEdit.putString("name", etName.getText().toString());
        prefsEdit.putFloat("gpa", fgpa);

        // Step 1e: Call commit() to save hte changes into SharedPreferneces
        prefsEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        // Step 2b: Retrieve the saved data from the SharedPreferences object
        String name = pref.getString("name", "");
        float gpa = pref.getFloat("gpa", 0f);

        // Step 2c: Update the UI element with the value
       etName.setText(name);
       etGPA.setText(gpa + "");
    }
}