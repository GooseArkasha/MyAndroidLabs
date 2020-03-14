package com.GooseArkasha.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Field> fields = new ArrayList();
    ListView fieldsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

        fieldsList = (ListView) findViewById(R.id.fieldsList);
        ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.list_iteam, fields);
        fieldsList.setAdapter(itemAdapter);
    }

    private void setInitialData() {
        for(int i = 0; i < 1000000; i++) {
            fields.add(new Field(i + 1, R.drawable.minicorgi));
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
