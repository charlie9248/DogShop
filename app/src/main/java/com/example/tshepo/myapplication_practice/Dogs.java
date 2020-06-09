package com.example.tshepo.myapplication_practice;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by tshepo on 02/05/2017.
 */

public class Dogs {


    private String name;
    private String breed;
    private int age;
    private String status;



    public Dogs(int age, String name, String breed , String status) {
        this.age = age;
        this.name = name;
        this.breed = breed;
        this.status = status;
    }// Dogs constructor


    public int getAge() {
        return age;
    }// end getAge


    public String getBreed() {
        return breed;
    }// end getBreed

    public String getName() {
        return name;
    }// end getName


    public String getStatus() {
        return status;
    }// end getStatus



}//  end class
