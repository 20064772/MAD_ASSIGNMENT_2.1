package com.example.mad_assignment_21;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class Display extends Fragment {

    private SharedViewModel viewModel;
    private List<Person> people;
    private Person user;


    public Display() {
        // Required empty public constructor
    }


    public static Display newInstance(String param1, String param2) {
        Display fragment = new Display();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        people = viewModel.getPeople();
        user = people.get(viewModel.getPosition());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_display, container, false);

        TextView name = (TextView) v.findViewById(R.id.Name);
        name.setText("Name: " +user.getName());
        TextView username= (TextView) v.findViewById(R.id.UserName);
        username.setText("UserName: " +user.getUserName());
        TextView email = (TextView) v.findViewById(R.id.email);
        email.setText("Email: " +user.getEmail());
        TextView suite = (TextView) v.findViewById(R.id.suite);
        suite.setText(user.getSuite());
        TextView street = (TextView) v.findViewById(R.id.street);
        street.setText(user.getStreet());
        TextView city = (TextView) v.findViewById(R.id.city);
        city.setText(user.getCity());
        TextView zip= (TextView) v.findViewById(R.id.zip);
        zip.setText("Zip code: " + user.getZip());
        TextView phone= (TextView) v.findViewById(R.id.phone);
        phone.setText("Phone #: " + user.getPhNumber());
        TextView website= (TextView) v.findViewById(R.id.website);
        website.setText("WebSite: " + user.getWebSite());
        TextView compName= (TextView) v.findViewById(R.id.companyName);
        compName.setText(user.getCompName());
        TextView cp = (TextView) v.findViewById(R.id.catchPhrase);
        cp.setText(user.getCompCatchPhrase());
        TextView bs = (TextView) v.findViewById(R.id.bs);
        bs.setText(user.getCompBs());
        Button button = (Button) v.findViewById(R.id.commentButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                CommentFrag commentFrag = new CommentFrag();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrag, commentFrag).addToBackStack(null).commit();
            }
        });
        return v;
    }

}