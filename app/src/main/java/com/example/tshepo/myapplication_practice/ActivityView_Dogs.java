package com.example.tshepo.myapplication_practice;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class ActivityView_Dogs extends AppCompatActivity implements FragmentList.SelectBreed{

    TextView desc;
    ImageView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdogs_);
        desc = (TextView) findViewById(R.id.description);
        status = (ImageView)findViewById(R.id.imageView2);


        if(findViewById(R.id.layout_default) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.fragment_detail))
                    .hide(manager.findFragmentById(R.id.fragment_status))
                    .show(manager.findFragmentById(R.id.fragment_list))
                    .commit();

        }// end if

        if(findViewById(R.id.layout_landscape) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment_detail))
                    .show(manager.findFragmentById(R.id.fragment_status))
                    .show(manager.findFragmentById(R.id.fragment_list))
                    .commit();

        }// end if

    }


    @Override
    public void SelectedBreed(int index) {

        if(findViewById(R.id.layout_default) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment_detail))
                    .show(manager.findFragmentById(R.id.fragment_status))
                    .hide(manager.findFragmentById(R.id.fragment_list))
                    .addToBackStack(null)
                    .commit();

        }// end if

        String  breed = DataStore.list.get(index).getBreed();
        String  StatusofDog = DataStore.list.get(index).getStatus();
        String breedInfo = "";



        if(StatusofDog.equalsIgnoreCase("Busy"))
        {
            status.setImageResource(R.drawable.busy_web);

        }else if(StatusofDog.equalsIgnoreCase("Booked in")){

            status.setImageResource(R.drawable.booked_web);

        }else {

            status.setImageResource(R.drawable.done_web);
        }// end else



        if(breed.equalsIgnoreCase("Labrador"))
        {
            breedInfo = DataStore.breedDetail[0];
        }else if(breed.equalsIgnoreCase("Huskie")){

            breedInfo = DataStore.breedDetail[1];

        }else if(breed.equalsIgnoreCase("Spaniel")){

            breedInfo = DataStore.breedDetail[2];
        }else{

            breedInfo = DataStore.breedDetail[3];

        }// end if
        desc.setText(breedInfo);
    } //end SelectedBreed

}// end class



