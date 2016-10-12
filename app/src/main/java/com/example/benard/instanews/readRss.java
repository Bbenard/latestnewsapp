package com.example.benard.instanews;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.w3c.dom.Document;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class readRss extends AsyncTask<Void,Void,Void> {
    Context context;
    String address="https://www.sciencemag.org/rss/news_current.xml";
    ProgressDialog progressDialog;
    URL url;

    public readRss(MainActivity mainActivity) {


    }

    public void readRss(Context context){
        this.context=context;
        progressDialog.setMessage("Loading...");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        processxml(Getdata());

        return null;

    }

    private void processxml(Document data) {
        if(data!=null) {
            Log.d("Root", data.getDocumentElement().getNodeName());
        }
    }


    @Override
    protected void onPreExecute() {
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
    public Document Getdata (){
        try {
            url = new URL(address);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("Get");
            InputStream inputStream=connection.getInputStream();
            DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=builderFactory.newDocumentBuilder();
            Document xmlDoc=builder.parse(inputStream);
            return xmlDoc;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }
}

