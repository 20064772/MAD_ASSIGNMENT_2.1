package com.example.mad_assignment_21;

import   android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    private final String urlString = "https://jsonplaceholder.typicode.com/users";
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLThread urlThread = new URLThread(urlString);
        Future<List<Person>> searchResponsePlaceHolder = executorService.submit(urlThread);
        List<Person> people = waitingForSearch(searchResponsePlaceHolder);

        //executorService.execute( urlThread);
    }


    public List<Person> waitingForSearch(){

    }
}