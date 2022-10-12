package com.example.mad_assignment_21;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class CommentViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView body;
    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        body = itemView.findViewById(R.id.body);
    }
}
