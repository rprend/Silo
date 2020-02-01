package com.silo.silo_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChartAdaptor extends RecyclerView.Adapter<ChartAdaptor.ChartViewHolder> {

    public static class ChartViewHolder extends RecyclerView.ViewHolder {

        private SiloLineChart chart;
        private TextView titleView;
        public ChartViewHolder(@NonNull View chartItem) {
            super(chartItem);
            this.titleView = chartItem.findViewById(R.id.chart_title);
            chart = new SiloLineChart( (LinearLayout) chartItem, chartItem.getContext());
        }
        public void newData(List<Entry> entries, String title ) {
            chart.newData(entries, title);
            titleView.setText(title);
        }


    }
    List<List<Entry>> entries;
    List<String> titles;

    public ChartAdaptor(List<List<Entry>> entries, List<String> titles) {
        this.entries = entries;
        this.titles = titles;
    }


    @NonNull
    @Override
    public ChartAdaptor.ChartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chartItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_view_item, parent, false);
        ChartAdaptor.ChartViewHolder vh = new ChartViewHolder(chartItem);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChartAdaptor.ChartViewHolder holder, int position) {
        holder.newData(entries.get(position), titles.get(0) );
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }
}
