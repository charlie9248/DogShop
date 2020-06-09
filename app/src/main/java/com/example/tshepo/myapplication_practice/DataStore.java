package com.example.tshepo.myapplication_practice;

import android.app.Application;
import android.content.res.Resources;

import java.util.ArrayList;

import static com.example.tshepo.myapplication_practice.R.array.age;

/**
 * Created by tshepo on 08/05/2017.
 */

public class DataStore extends Application {


    static  ArrayList<Dogs> list;
    static  String[] breedDetail;
    String [] names,status,breed;
    int [] age;



    @Override
    public void onCreate() {
        super.onCreate();

        list = new ArrayList<Dogs>();
        Resources res = getResources();
        names = res.getStringArray(R.array.names);
        breed = res.getStringArray(R.array.breed);
        status = res.getStringArray(R.array.status);
        breedDetail = res.getStringArray(R.array.breed_info);
        age = res.getIntArray(R.array.age);


        for (int i = 0 ; i < names.length ; i++)
        {
            Dogs dogs = new Dogs(age[i],names[i],breed[i],status[i]);
            list.add(dogs);

        }// end for

    }// end Oncreate()

}//class
