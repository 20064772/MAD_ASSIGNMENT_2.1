package com.example.mad_assignment_21;


import android.arch.lifecycle.ViewModel;

import java.util.List;

public class SharedViewModel extends ViewModel {

    private List<Person> people;
    private List<Comments> comments;
    private int position;

    public SharedViewModel(){
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public void setComments(List<Comments> comments){
        this.comments = comments;
    }

    public List<Person> getPeople(){
        return people;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
