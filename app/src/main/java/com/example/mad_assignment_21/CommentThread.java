package com.example.mad_assignment_21;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CommentThread implements Callable {

    private String urlString;
    HttpURLConnection conn;
    List<Comments> comments;

    public CommentThread(String URL){
        this.urlString = URL;
        this.conn = null;
        comments = new ArrayList<>();
    }



    @Override
    public Object call(){
        URL url = null;
        try {
            url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            isConectionOkay();
            String data = IOUtils.toString(conn.getInputStream(), StandardCharsets.UTF_8);
            makeObjects(data);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public void makeObjects(String data) {

        try {
            JSONArray job = new JSONArray(data);
            for(int x = 0; x < job.length(); x++){
                JSONObject jComment = job.getJSONObject(x);
                Comments userComment = new Comments(jComment.getInt("userId"), jComment.getInt("id"), jComment.getString("title"), jComment.getString("body"));
                comments.add(userComment);
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
