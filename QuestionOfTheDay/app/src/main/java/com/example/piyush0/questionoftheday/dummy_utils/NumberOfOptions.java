package com.example.piyush0.questionoftheday.dummy_utils;

import java.util.ArrayList;

/**
 * Created by piyush0 on 05/12/16.
 */

public class NumberOfOptions {

    public static ArrayList<Integer> getNumberOfOptions(){
        ArrayList<Integer> retVal = new ArrayList<>();

        for(int i = 5; i<=10; i++){
            retVal.add(i);
        }

        return retVal;
    }
}
