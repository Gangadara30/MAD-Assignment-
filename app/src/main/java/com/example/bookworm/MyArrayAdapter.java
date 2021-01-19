package com.example.bookworm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class MyArrayAdapter extends ArrayAdapter<String> {

    String[] names;
    String[] prices;

    public MyArrayAdapter(@NonNull Context context, String[] name, String[] price) {
        super(context, R.layout.row, R.id.itemname, name);

        this.names= name;
        this.prices = price;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.row,parent,false);

        TextView name = row.findViewById(R.id.itemname);
        TextView price = row.findViewById(R.id.itemprice);

        name.setText(names[position]);
        price.setText(prices[position]);

        return row;
    }
}
