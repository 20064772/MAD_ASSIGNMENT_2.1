package com.example.mad_assignment_21;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class URLThread implements Callable {


    private String urlString;
    HttpURLConnection conn;
    List<Person> people;


    public URLThread(String URL){
        this.urlString = URL;
        this.conn = null;
        people = new ArrayList<>();
    }


    @Override
    public Object call() {
        URL url = null;
        try {
            url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            isConectionOkay();
            //InputStream inputStream = conn.getInputStream();
            String data = IOUtils.toString(conn.getInputStream(), StandardCharsets.UTF_8);
            makeObjects(data);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    public void makeObjects(String data) {

        try {
            JSONArray job = new JSONArray(data);
            for(int x = 0; x < job.length(); x++){
                JSONObject jPerson = job.getJSONObject(x);
                JSONObject jAddress = jPerson.getJSONObject("address");
                JSONObject jGeo = jAddress.getJSONObject("geo");
                JSONObject jCompany = jPerson.getJSONObject("company");
                Address address = new Address(jAddress.getString("street"),jAddress.getString("suite"), jAddress.getString("city"), jAddress.getString("zipcode"), jGeo.getString("lat"), jGeo.getString("lng"));
                Company company  = new Company(jCompany.getString("name"), jCompany.getString("catchPhrase"), jCompany.getString("bs"));
                Person person = new Person(jPerson.getInt("id"), jPerson.getString("name"), jPerson.getString("username"), jPerson.getString("email"), address, jPerson.getString("phone"), jPerson.getString("website"), company);
                people.add(person);
            }
        }
        catch (JSONException e){

        }
    }

    public void isConectionOkay(){

        boolean isOkay;
        try{
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                isOkay = true;
            }
            else{
                isOkay = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
