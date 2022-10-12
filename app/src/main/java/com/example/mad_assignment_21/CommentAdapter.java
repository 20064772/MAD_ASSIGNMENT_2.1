package com.example.mad_assignment_21;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private List<Comments> userComments;


    public CommentAdapter(List<Comments> usercomments, int id) {
        this.userComments = usercomments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.comment_item, parent,false);
        CommentViewHolder commentViewHolder = new CommentViewHolder(v);
        return  commentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int i) {

        holder.title.setText(userComments.get(i).getTitle());
        holder.body.setText(userComments.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return userComments.size();
    }
}
