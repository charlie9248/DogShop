package com.example.tshepo.myapplication_practice;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityBook_A_Visit extends AppCompatActivity {

     EditText txtDogName, txtDogBreed, txtDogAge;
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_a_visit);

        desc = (TextView) findViewById(R.id.description);
        txtDogName = (EditText) findViewById(R.id.txtName);
        txtDogBreed = (EditText) findViewById(R.id.txtbreed);
        txtDogAge = (EditText) findViewById(R.id.txtAge);
    }// end onCreate method

    public void btnSubmit(View view) {

        if(txtDogName.getText().toString().isEmpty() || txtDogBreed.getText().
                toString().isEmpty() || txtDogAge.getText().toString().isEmpty())
        {
            Toast("Please enter all fields");
        }else if(!(txtDogBreed.getText().toString().equalsIgnoreCase("Spaniel") ||txtDogBreed.getText().toString().equalsIgnoreCase("Labrador")||txtDogBreed.getText().toString().equalsIgnoreCase("Huskie")||txtDogBreed.getText().toString().equalsIgnoreCase("Golden Retriever")))
        {
            Toast("Please enter correct breed");
        }
        else
        {

            String status = "Booked In";
            String name  = txtDogName.getText().toString().trim();
            String breed  = txtDogBreed.getText().toString().trim();
            String age  = txtDogAge.getText().toString().trim();

            int ageConvert = Integer.parseInt(age);
            Dogs dogs  = new Dogs(ageConvert,name,breed,status);
            DataStore.list.add(dogs);
            Toast("Dog Successfully Added");


            Intent close = new Intent(this,MainActivity.class);
            startActivity(close);
            finish();



        }// end else

    }// end btnSubmit method

    public  void Toast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    } //end Toast method


}// end class
