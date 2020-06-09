package com.example.tshepo.myapplication_practice;


import android.content.res.Resources;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList extends ListFragment {


    interface SelectBreed
    {
        void  SelectedBreed(int index);

    }// end SelectBreed interface

    private SelectBreed selectBreed;


    public FragmentList() {
        // Required empty public constructor
    }// constructor


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(this.getActivity().findViewById(R.id.layout_default) == null)
        {
            selectBreed.SelectedBreed(0);
        }

        DogsAdapter dogsAdapter = new DogsAdapter(getContext(),DataStore.list);
        this.setListAdapter(dogsAdapter);

    }// end onActivityCreated

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            selectBreed =(SelectBreed) context;
        }catch (ClassCastException e){
            throw new ClassCastException (context.toString()+"must called the interface called"+ "SelectBreed");
        }// end try catch
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {


        if (selectBreed != null) {
            selectBreed.SelectedBreed(position);
            Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        }// end if
    }// end onListItemClick

}// end class
