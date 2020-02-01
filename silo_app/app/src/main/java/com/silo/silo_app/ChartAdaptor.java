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

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChartAdaptor extends BaseAdapter {



    List<List<Entry>> entries;
    List<String> titles;
    List<String> types;
    LayoutInflater inflate;
    public ChartAdaptor(List<List<Entry>> entries, List<String> titles, List<String> types, Context context) {
        this.entries = entries;
        this.titles = titles;
        this.types = types;
        inflate = LayoutInflater.from(context);
    }
    public void replaceData (List<List<Entry>> entries, List<String> titles, List<String> types) {
        this.entries = entries;
        this.titles = titles;
        this.types = types;

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
            case "line" :
                siloChart = new SiloLineChart( (FrameLayout) chart, view.getContext());
                break;
            case "pie" :
                siloChart = new SiloPieChart( (FrameLayout) chart, view.getContext());
                break;
            case "score" : siloChart = null;
            default: siloChart = null;
        }
        try {
            siloChart.newData(entries.get(position-1), titles.get(position-1));
            titleView.setVisibility(View.VISIBLE);

            titleView.setText(titles.get(position-1));
            chart.setVisibility(View.VISIBLE);
            ringView.setVisibility(View.INVISIBLE);

        } catch (Exception e){
            titleView.setVisibility(View.INVISIBLE);
            chart.setVisibility(View.INVISIBLE);
            ringView.setVisibility(View.VISIBLE);
            ringView.setEcoValue(.70f);
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
