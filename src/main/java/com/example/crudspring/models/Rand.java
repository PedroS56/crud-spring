package com.example.crudspring.models;

import java.util.Random;

public class Rand {
    private int [] numArray;
    public int[] getNumArray(){
        return numArray;
    }    

    public void setNumArray(int[] numArray){
        this.numArray = numArray;
    }

    public Rand(long size,  int origin, int bound){
        Random random = new Random();
        size = size < 1001? size : 1000;
        numArray = random.ints(size, origin, bound).toArray();
    }
}