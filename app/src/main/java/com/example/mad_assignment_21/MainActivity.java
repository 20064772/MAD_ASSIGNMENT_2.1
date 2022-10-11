package com.example.mad_assignment_21;

import android.support.v4.app.FragmentManager;
import   android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    private final String urlString = "https://jsonplaceholder.typicode.com/users";
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        URLThread urlThread = new URLThread(urlString);
        Future<List<Person>> searchResponsePlaceHolder = executorService.submit(urlThread);
        //List<Person> people = waitingForSearch(searchResponsePlaceHolder);
        try {
            people = searchResponsePlaceHolder.get();
            int x = people.size();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(people != null ) {

            setContentView(R.layout.activity_main);
            FragmentManager fm = getSupportFragmentManager();
            userFrag user = (userFrag) fm.findFragmentById(R.id.userView);
            if (user == null){
                user =  new userFrag();
                Bundle b = new Bundle();
                b.putSerializable("people", (Serializable) people);
                fm.beginTransaction().add(R.id.mainFrag, user).commit();
            }
        }
        else{

            Toast toast=Toast.makeText(getApplicationContext(),"Waiting on other thread",Toast.LENGTH_SHORT);
        }




    }
}