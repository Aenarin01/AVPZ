package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;

import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static com.example.sportify.utils.NetworkUtils.generateURL;
import static com.example.sportify.utils.NetworkUtils.getResponseFromURL;



public class TrainList extends AppCompatActivity {
    private TextView trainsList;
    private Button register;
    class task extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            String res = null;
            try {
                res = getResponseFromURL(urls[0]);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return "Запрос был сгенерирован, но БД НЕ ПОДКЛЮЧАЕТЬСЯ!!!!!!!!!!";



        }

        @Override
        protected void onPostExecute(String res) {
            trainsList = (TextView) findViewById(R.id.textView7);
            trainsList.setText(res);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_list);
        trains_list_onCreate();


    }




    public void trains_list_onCreate(){
        trainsList = (TextView)findViewById(R.id.textView7);
        register = (Button)findViewById(R.id.button);
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        URL generatedURL = generateURL();
                        new task().execute(generatedURL);

                        /*String respons = null;
                        try {
                            respons = getResponseFromURL(generateURL);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        */

                        //trainsList.setText(getUsers());

                    }
                }
        );


    }
    /*connection string(long) -
            const MongoClient = require('mongodb').MongoClient;
const uri = "mongodb+srv://vlad:as1305@cluster0.wxkyd.mongodb.net/AVPZ?retryWrites=true&w=majority";
const client = new MongoClient(uri, { useNewUrlParser: true });
client.connect(err => {
  const collection = client.db("test").collection("devices");
        // perform actions on the collection object
        client.close();
    });*/
    /*public String getRes(){
        String str = "";
        try {
            str = getRespons(getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static URL getURL(){
        MongoClientURI uri = new MongoClientURI( "mongodb+srv://vlad:as1305@cluster0.wxkyd.mongodb.net/AVPZ?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase(uri.getDatabase());

        URL url = null;
        try {
            url = new URL(uri.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }
    public static String getRespons(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = urlConnection.getInputStream();
        Scanner scaner = new Scanner(in);
        scaner.useDelimiter(" ");
        boolean hasInput = scaner.hasNext();
        if (hasInput) {
            return scaner.next();
        } else {
            return null;
        }
    }

    // HttpURLConnection urlConnection = url*/



}