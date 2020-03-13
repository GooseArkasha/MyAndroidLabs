package com.GooseArkasha.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Field>{

    private LayoutInflater inflater;
    private int layout;
    private List<Field> fields;

    public ItemAdapter(Context context, int resource, List<Field> fields) {
        super(context, resource, fields);
        this.fields = fields;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView CorgiView = (ImageView) view.findViewById(R.id.imageCorgi);
        TextView numberView = (TextView) view.findViewById(R.id.textNumber);

        Field field = fields.get(position);

        CorgiView.setImageResource(field.getImageResource());
        numberView.setText(field.getNumber());
        return view;
    }

}
