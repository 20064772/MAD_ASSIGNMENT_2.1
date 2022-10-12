package com.example.mad_assignment_21;

import android.content.Intent;
import android.support.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.io.InputStreamReader;
import java.util.List;

public class UserAdaptor extends RecyclerView.Adapter<UserViewHolder> {

    List<Person> people;
    SharedViewModel viewModel;

    public UserAdaptor(List<Person> people, SharedViewModel viewModel){
        this.people = people;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v  = layoutInflater.inflate(R.layout.user_item, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(v);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.username.setText(people.get(position).getUserName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setPosition(people.get(holder.getAdapterPosition()).getId());
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Display display = new Display();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrag, display).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return people.size();
    }
}
