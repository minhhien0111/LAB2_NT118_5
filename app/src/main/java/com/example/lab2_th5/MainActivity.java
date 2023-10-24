package com.example.lab2_th5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerDish;
    AdapterSpinner adapterSpinner;
    ArrayList<Dish> list_dish;
    ArrayList<Dish> gv_list_dish;
    Dish selected_dish;
    CheckBox checkBox;
    Button button;
    GridView gridView;
    EditText name;
    AdapterDish adapterDish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_dish = new ArrayList<Dish>();

        list_dish.add(new Dish("Thumbnail 1", R.drawable.first_thumbnail));
        list_dish.add(new Dish("Thumbnail 2", R.drawable.second_thumbnail));
        list_dish.add(new Dish("Thumbnail 3", R.drawable.third_thumbnail));
        list_dish.add(new Dish("Thumbnail 4", R.drawable.fourth_thumbnail));
        list_dish.add(new Dish("Thumbnail 5", R.drawable.fifth_thumbnail));

        spinnerDish = (Spinner) findViewById(R.id.spinner);

        adapterSpinner = new AdapterSpinner(MainActivity.this, R.layout.item_dropdown_spinner, list_dish);
        spinnerDish.setAdapter(adapterSpinner);

        spinnerDish.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                selected_dish = list_dish.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        checkBox = (CheckBox) findViewById(R.id.checkBox) ;
        button  = (Button) findViewById(R.id.Inputbutton) ;
        gridView = (GridView) findViewById(R.id.gvDish);

        name = (EditText) findViewById(R.id.NameEdittext);
        gv_list_dish = new ArrayList<Dish>();
        adapterDish = new AdapterDish(this, R.layout.item_dish,gv_list_dish);
        gridView.setAdapter(adapterDish);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_name = name.getText().toString();
                Dish newdish = new Dish(s_name,selected_dish.getThumbnail());
                if (checkBox.isChecked())
                {
                    newdish.setIs_promotion(true);
                }
                else
                {
                    newdish.setIs_promotion(false);
                }

                gv_list_dish.add(newdish);
                name.setText("");
                spinnerDish.setSelection(0);
                checkBox.setChecked(false);
                adapterDish.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}