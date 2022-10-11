package com.example.mad_assignment_21;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class UserAdaptor extends RecyclerView.Adapter<UserViewHolder> {

    List<Person> people;

    public UserAdaptor(List<person> people){
        this.people = people;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return people.size();
    }
}
