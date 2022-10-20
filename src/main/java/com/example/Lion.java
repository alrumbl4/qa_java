package com.example;

import java.util.List;

public class Lion {

    Feline feline;
    boolean hasMane;

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public int getKittens() { return feline.getKittens(); }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}