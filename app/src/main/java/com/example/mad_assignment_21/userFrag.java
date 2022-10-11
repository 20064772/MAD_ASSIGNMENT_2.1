package com.example.mad_assignment_21;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.util.List;


public class userFrag extends Fragment {


    List<Person> people;

    public userFrag() {
        // Required empty public constructor
    }

    public static userFrag newInstance(String param1, String param2) {
        userFrag fragment = new userFrag();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        RecyclerView rv = v.findViewById(R.id.userView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        UserAdaptor userAdaptor = new UserAdaptor(people);
        rv.setAdapter(userAdaptor);
        return  v;
    }
}