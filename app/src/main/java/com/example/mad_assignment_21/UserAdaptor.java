package com.example.mad_assignment_21;

import android.support.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

public class UserAdaptor extends RecyclerView.Adapter<UserViewHolder> {

    List<Person> people;

    public UserAdaptor(List<Person> people){
        this.people = people;
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



    }


    @Override
    public int getItemCount() {
        return people.size();
    }
}
