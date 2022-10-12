package com.example.mad_assignment_21;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CommentFrag extends Fragment {

    private SharedViewModel viewModel;
    private List<Comments> comments;
    private List<Comments> userComments;
    private List<Person> people;
    private int id;

    public CommentFrag() {
        // Required empty public constructor
    }


    public static CommentFrag newInstance(String param1, String param2) {
        CommentFrag fragment = new CommentFrag();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        comments = viewModel.getComments();
        people = viewModel.getPeople();
        id = viewModel.getPosition();
        makeList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_comment, container, false);
        RecyclerView rv = v.findViewById(R.id.commRecyc);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        CommentAdapter commentAdapter = new CommentAdapter(userComments, id);
        rv.setAdapter(commentAdapter);
        TextView header = v.findViewById(R.id.header);
        header.setText("Comments From: \n" + people.get(id).getUserName());
        return v;
    }


    public void makeList(){
        userComments = new ArrayList<>();
        for(Comments c : comments){
            if (c.getId() == id){
                userComments.add(c);
            }
        }
    }
}