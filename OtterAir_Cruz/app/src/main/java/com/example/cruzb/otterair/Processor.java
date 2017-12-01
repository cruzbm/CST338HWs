package com.example.cruzb.otterair;

import android.app.Application;

import java.util.HashMap;

/**
 * Created by cruzb on 11/25/2017.
 */

public class Processor extends Application {
    private HashMap<String,String> UP = new HashMap<>();

    public void addUser(String uName, String pWord) {
        this.UP.put(uName, pWord);
    }
}


//Set
//((MyApp) this.getApplication()).setVar("foo");
//Get
//String s = ((MyApp) this.getApplication()).getVar();