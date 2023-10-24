package com.example.lab2_th5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterDish extends ArrayAdapter<Dish> {
    private Context context;
    public AdapterDish(Activity context, int layoutID, ArrayList<Dish> objects) {
        super(context, layoutID, objects);
        this.context = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, null,
                            false);
        }
        // Get item
        Dish dish = getItem(position);
        // Get view
        TextView tvFullName = (TextView)
                convertView.findViewById(R.id.txtMonan);
        ImageView ivDish = (ImageView)
                convertView.findViewById(R.id.imgDish);
        ImageView ivStar = (ImageView)
                convertView.findViewById(R.id.icnStar);
        tvFullName.setSelected(true);
        ivDish.setImageResource(dish.getThumbnail());
        if (dish.getName()!=null) {
            tvFullName.setText(dish.getName());
        }
        else tvFullName.setText("");
        if (dish.getis_promotion())
        {
            ivStar.setVisibility(View.VISIBLE);
        }
        else
        {
            ivStar.setVisibility(View.GONE);
        }
        return convertView;
    }
}
