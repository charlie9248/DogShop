package com.example.tshepo.myapplication_practice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import  java.util.ArrayList;

/**
 * Created by tshepo on 04/05/2017.
 */

public class DogsAdapter extends ArrayAdapter<Dogs> {

    private  final Context context;
    private  final ArrayList<Dogs> values;

    public DogsAdapter(Context context, ArrayList<Dogs> list) {
        super(context, R.layout.custom_layout,list);
        this.context = context;
        this.values = list;
    }// end DogsAdapter constructor


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_layout,parent,false);

        // reference  views in the customLayout
        TextView txtName_Age = (TextView) rowView.findViewById(R.id.txtName_Age);
        TextView txtbreed = (TextView) rowView.findViewById(R.id.txtBreed);


        // set views in the customLayout
        txtName_Age.setText(values.get(position).getName()+ " " + "(Age:" + values.get(position).getAge() + ")");
        txtbreed.setText(values.get(position).getBreed());
        ImageView dogImage = (ImageView) rowView.findViewById(R.id.imageDog);
        ImageView statusImage = (ImageView) rowView.findViewById(R.id.imageStatus);


        if(values.get(position).getStatus().equalsIgnoreCase("Busy"))
        {
            statusImage.setImageResource(R.drawable.busy_web);

        }else if(values.get(position).getStatus().equalsIgnoreCase("Booked In")){

            statusImage.setImageResource(R.drawable.booked_web);
        }else {

            statusImage.setImageResource(R.drawable.done_web);
        }// end else



        if(values.get(position).getBreed().equalsIgnoreCase("Spaniel")) {

            dogImage.setImageResource(R.drawable.spaniel_web);


        }else if(values.get(position).getBreed().equalsIgnoreCase("Huskie")) {

            dogImage.setImageResource(R.drawable.huskie_web);

        }else if(values.get(position).getBreed().equalsIgnoreCase("Labrador")) {

            dogImage.setImageResource(R.drawable.labrador_web);

        }else {

            dogImage.setImageResource(R.drawable.golden_retriever_web);
        }// end else

        return rowView;

    }// end getView method
}// end class
