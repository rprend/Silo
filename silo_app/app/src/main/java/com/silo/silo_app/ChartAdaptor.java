package com.silo.silo_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChartAdaptor extends BaseAdapter {

    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("layout_info.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public void makeFromWeb() {

        try {
            JSONObject lay = new JSONObject(loadJSONFromAsset(context)).getJSONObject("Layout1");
            float sus_ind = (float) lay.getDouble("sustainability") / 1000;
            float eff_ind = (float) lay.getDouble("efficiency") / 1000;
            JSONObject vars = lay.getJSONObject("variables");
            JSONArray water = vars.getJSONArray("water");
            JSONArray power = vars.getJSONArray("water");
            JSONArray temp = vars.getJSONArray("water");

            List<Entry> susEntry = Arrays.asList(new Entry(sus_ind, 1));
            List<Entry> envEntry = Arrays.asList(new Entry(eff_ind, 1));

            List<Entry> waterEntry = new ArrayList<>();
            for (int i = 0; i < water.length()/6000; i++) {
                waterEntry.add(new Entry(i, water.getInt(i)));
            }
            List<Entry> powerEntry = new ArrayList<>();
            for (int i = 0; i < power.length(); i++) {
                waterEntry.add(new Entry(i, power.getInt(i)));
            }
            List<Entry> tempEntry = new ArrayList<>();
            for (int i = 0; i < temp.length(); i++) {
                waterEntry.add(new Entry(i, power.getInt(i)));
            }

            entries.clear();
            titles.clear();
            types.clear();

            entries.add(susEntry);
            titles.add("Sustainability Index");
            types.add("score");

            entries.add(envEntry);
            titles.add("Environmental Index");
            types.add("score");

            entries.add(waterEntry);
            titles.add("Water Use");
            types.add("line");

            entries.add(powerEntry);
            titles.add("Power Use");
            types.add("line");

            entries.add(tempEntry);
            titles.add("Building Temperature");
            types.add("line");

            this.notifyDataSetChanged();

        } catch (Exception e) {
            this.notifyDataSetInvalidated();
        }


    }

    List<List<Entry>> entries;
    List<String> titles;
    List<String> types;
    LayoutInflater inflate;
    Context context;

    public ChartAdaptor(List<List<Entry>> entries, List<String> titles, List<String> types, Context context) {
        this.entries = entries;
        this.titles = titles;
        this.types = types;
        this.context = context;
        inflate = LayoutInflater.from(context);
    }

    public ChartAdaptor(Context context) {
        this.context = context;
        inflate = LayoutInflater.from(context);
    }

    public void replaceData(List<List<Entry>> entries, List<String> titles, List<String> types) {
        this.entries = entries;
        this.titles = titles;
        this.types = types;
        this.notifyDataSetChanged();

    }


    @Override
    public int getCount() {
        return types.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflate.inflate(R.layout.chart_view_item, null);

        TextView titleView = view.findViewById(R.id.chart_title);
        View chart = view.findViewById(R.id.graph_container);
        chart.setVisibility(View.VISIBLE);
        RingView ringView = view.findViewById(R.id.ring_view);
        String type = types.get(position);
        SiloChart siloChart;
        switch (type) {
            case "line":
                siloChart = new SiloLineChart((FrameLayout) chart, view.getContext());
                break;
            case "pie":
                siloChart = new SiloPieChart((FrameLayout) chart, view.getContext());
                break;
            case "score":
                siloChart = null;
                break;
            default:
                siloChart = null;
        }
        try {
            siloChart.newData(entries.get(position), titles.get(position));
            titleView.setVisibility(View.VISIBLE);

            titleView.setText(titles.get(position));
            chart.setVisibility(View.VISIBLE);
            ringView.setVisibility(View.INVISIBLE);

        } catch (Exception e) {
            titleView.setVisibility(View.VISIBLE);

            titleView.setText(titles.get(position));
            chart.setVisibility(View.INVISIBLE);
            ringView.setVisibility(View.VISIBLE);
            ringView.setEcoValue(entries.get(position).get(0).getX());
        }

        return view;
    }
/*    @Override
    public View getView(int position, View  convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = container.getContext().getgetLayoutInflater().inflate(R.layout.list_item, container, false);
        }

        ((TextView) convertView.findViewById(android.R.id.text1))
                .setText(getItem(position));
        return convertView;


        ////////////
        View chartItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_view_item, parent, false);

    }*/


}
