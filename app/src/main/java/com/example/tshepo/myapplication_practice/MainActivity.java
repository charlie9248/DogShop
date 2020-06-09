package com.example.tshepo.myapplication_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }// end onCreate method


    public void btnViewDogs(View view) {

        Intent intent = new Intent(this,ActivityView_Dogs.class);
        startActivity(intent);
    }//end  btnViewDogs


    public void btnVisit(View view) {


        Intent intent = new Intent(this,ActivityBook_A_Visit.class);
        startActivity(intent);
    }// btnVisit
} // end class
