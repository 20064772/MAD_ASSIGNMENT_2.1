package com.example.mad_assignment_21;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView username;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.userName);
    }
}
