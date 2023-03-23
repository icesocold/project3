package com.example.algorithm;
import java.util.*;

public class Random {
    private String name;
   
    public Double getProbability() {
      //  Random rand = new Random();
        double ran =Math.random()*4;
        switch ((int) ran){
            case 0:
                this.name="Poisson";
                return 1.0;
            case 1:
                this.name = "Uniform";
                return 1.0;
            case 2:
                this.name = "Bimodal";
                return 1.0;
        }
        this.name = "Normal";
        // double i = rand.nextD
        return 0.1;
    }

    public String getName(){
        return this.name;
    }
}
