package com.example.classes;

import com.example.main.Scene;

public class Text {
    private Scene scene;
    private double x;
    private double y;
    private String text,fontSize,color;
    public Text(Scene scene, double d, double e, String a, String b, String c){
        this.scene = scene;
        this.text= a;
        this.x =d;
        this.y=e;
        this.fontSize=b;
        this.color =c ;
    }
   
    
}