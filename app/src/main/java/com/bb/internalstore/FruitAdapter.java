package com.bb.internalstore;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private List<Fruit> fruit;

    public FruitAdapter(List<Fruit> fruit) {
        this.fruit = fruit;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);

        Log.d("TAG_XX", "Fruit: " + fruit);

        ((TextView) view.findViewById(R.id.main_text)).setText(fruit.get(position).toString());

        return view;
    }
}
