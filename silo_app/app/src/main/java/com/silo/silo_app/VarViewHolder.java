package com.silo.silo_app;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.data.Entry;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class VarViewHolder extends RecyclerView.ViewHolder {

    public VarViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void newData(List<Entry> entries, String title);

    public static class ChartViewHolder extends VarViewHolder {

        private SiloLineChart chart;
        private TextView titleView;

        public ChartViewHolder(@NonNull View chartItem) {
            super(chartItem);
            this.titleView = chartItem.findViewById(R.id.chart_title);
            chart = new SiloLineChart((LinearLayout) chartItem, chartItem.getContext());
        }

        public void newData(List<Entry> entries, String title) {
            chart.newData(entries, title);
            titleView.setText(title);
        }
    }

    public static class SusScoreHolder extends VarViewHolder {
        //TODO by teddy
        public SusScoreHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void newData(List<Entry> entries, String title) {
            return;
        }
    }
}