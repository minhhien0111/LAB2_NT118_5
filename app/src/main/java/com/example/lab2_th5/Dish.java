package com.example.lab2_th5;

public class Dish {
    String name;
    int thumbnail;
    boolean is_promotion;

    Dish(String name, int thumbnail, boolean is_promotion)
    {
        this.name = name;
        this.thumbnail = thumbnail;
        this.is_promotion = is_promotion;
    }
    Dish(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }
    String getName(){return this.name;}
    int getThumbnail()
    {
        if(this.thumbnail == R.drawable.first_thumbnail)
        {return R.drawable.first_thumbnail;}
        if (this.thumbnail == R.drawable.second_thumbnail) {return R.drawable.second_thumbnail;}
        if (this.thumbnail == R.drawable.third_thumbnail) {return R.drawable.third_thumbnail;}
        if (this.thumbnail == R.drawable.fourth_thumbnail) {return R.drawable.fourth_thumbnail;}
        else  return R.drawable.fifth_thumbnail;
        //return this.thumbnail;
    }
    boolean getis_promotion(){return this.is_promotion;}
    void setIs_promotion(boolean is_promotion)
    {
        this.is_promotion = is_promotion;
    }
}
