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

public class ChartAdaptor extends RecyclerView.Adapter<VarViewHolder> {



    List<List<Entry>> entries;
    List<String> titles;

    public ChartAdaptor(List<List<Entry>> entries, List<String> titles) {
        this.entries = entries;
        this.titles = titles;
    }


    @NonNull
    @Override
    public VarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chartItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_view_item, parent, false);
        switch (viewType) {

            case 0: return new VarViewHolder.SusScoreHolder(chartItem);
            default: return new VarViewHolder.ChartViewHolder(chartItem);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull VarViewHolder holder, int position) {
        holder.newData(entries.get(position), titles.get(position) );
    }

    @Override
    public int getItemViewType(int position) {
        position = Math.max(position, 1);
        return position;
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }
}
