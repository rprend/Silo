package com.silo.silo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            entries.add(new Entry(i, i*i));
        }
        //charts -- mult lines //2560X1312
        SiloLineChart chart = new SiloLineChart("test", "this is test data", entries, (LinearLayout) findViewById(R.id.graph_root), this);
    }
}
