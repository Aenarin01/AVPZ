package com.example.sportify.utils;

import android.net.Uri;
import android.util.Log;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class NetworkUtils {

    public static final String Sportify_BASE_URL = "http://localhost:6000/api/auth/login";
    public static final String LOGIN = "auth/login";

    public static URL generateURL(){
        Uri builtUri = Uri.parse(Sportify_BASE_URL);
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
    public static String getResponseFromURL(URL url) throws IOException, JSONException {


        /*HttpURLConnection con = (HttpURLConnection) url.openConnection();

        if(con.getResponseCode() != HttpURLConnection.HTTP_OK)
        {
            return null;
        }

        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept","application/json");
        con.setConnectTimeout(20000);
        con.setReadTimeout(20000);
        con.setDoOutput(true);
        con.setDoInput(true);
        JSONObject logIn   = new JSONObject();

        logIn.put("email","kiril@gmail.com");
        logIn.put("password", "123456");
        Log.i("JSON", logIn.toString());



        //WRITE



        OutputStream os=con.getOutputStream();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
        bw.write(logIn.toString());
        bw.flush();
        //RELEASE RES
        bw.close();
        os.close();
        //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
        Log.i("GET", os.toString());

        Log.i("STATUS", String.valueOf(con.getResponseCode()));
        Log.i("MSG" , con.getResponseMessage());
        return con.getResponseMessage();*/
        /*String response = "";
        try {


            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;*/





        /*OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(logIn.toString());
        wr.flush();

        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return "" + sb.toString();
        } else {
            return con.getResponseMessage();
        }*/

            /*JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("key1", "value1");
            jsonObject.accumulate("key2", "value2");

            boolean success = sendPost(SERVER_URL + "/v1/auth", jsonObject);*/

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(20000);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            JSONObject logIn   = new JSONObject();

            logIn.put("email","kiril@gmail.com");
            logIn.put("password", "123456");
            Log.i("JSON", logIn.toString());
            OutputStream os=urlConnection.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(logIn.toString());
            bw.flush();
            //RELEASE RES
            bw.close();
            os.close();
            return urlConnection.getResponseMessage();
        } finally {
            urlConnection.disconnect();
        }
    }
    /*public static void sendPost() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Uri builtUri = Uri.parse(Sportify_BASE_URL);
                    URL url = null;
                    try {
                        url = new URL(builtUri.toString());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("email","kiril@gmail.com");
                    jsonParam.put("password", "123456");


                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
                    os.writeBytes(jsonParam.toString());

                    os.flush();
                    os.close();

                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }*/

}
