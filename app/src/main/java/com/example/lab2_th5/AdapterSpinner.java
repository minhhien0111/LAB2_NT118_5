package com.example.lab2_th5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.graphics.drawable.Drawable;

public class AdapterSpinner extends ArrayAdapter<Dish> {
    private Context context;
    private int layout;
    public AdapterSpinner(Context context, int layoutID, ArrayList<Dish> array)
    {
        super(context, layoutID, array);
        this.context = context;
        this.layout = layoutID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_selected_dish, null, false);
        Dish dish = getItem(position);
        TextView tvFullName = (TextView) view.findViewById(R.id.item_dish_tv_fullname);
        if (dish.getName()!=null) {
            tvFullName.setText(dish.getName());
        }
        else tvFullName.setText("");
        return view;
    }
    public View getDropDownView(final int position, View convertView, ViewGroup parent)
    {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(R.layout.item_dropdown_spinner, parent, false);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dropdown_spinner, parent,
                            false);
        }
        Dish dish = getItem(position);
        TextView tvFullName = (TextView) convertView.findViewById(R.id.item_dish_tv_fullname_dropdown);
        ImageView ivDish = (ImageView) convertView.findViewById(R.id.item_dish_iv);
        LinearLayout llParent = (LinearLayout)convertView.findViewById(R.id.item_dropdown_spinner_parent);
        ivDish.setImageResource(dish.getThumbnail());
        if (dish.getName()!=null) {
            tvFullName.setText(dish.getName());
        }
        else tvFullName.setText("");
        return convertView;
    }
}
