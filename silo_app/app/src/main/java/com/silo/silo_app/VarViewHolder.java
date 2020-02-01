package com.silo.silo_app;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class VarViewHolder extends RecyclerView.ViewHolder {

    public VarViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void newData(List<Entry> entries, String title);

    public static class ChartViewHolder extends VarViewHolder {

        private SiloLineChart siloChart;
        private LineChart chart;
        private TextView titleView;

        public ChartViewHolder(@NonNull View chartItem) {
            super(chartItem);
            this.titleView = chartItem.findViewById(R.id.chart_title);
            chart = itemView.findViewById(R.id.graph_container);
            chart.setVisibility(View.VISIBLE);
            siloChart = new SiloLineChart( chart, chartItem.getContext());
        }

        public void newData(List<Entry> entries, String title) {
            siloChart.newData(entries, title);
            titleView.setText(title);
            titleView.setVisibility(View.VISIBLE);
            chart.setVisibility(View.VISIBLE);
        }
    }

    public static class SusScoreHolder extends VarViewHolder {
        private RingView ringView;
        private TextView titleView;
        private LineChart chart;
        //TODO by teddy
        public SusScoreHolder(@NonNull View itemView) {
            super(itemView);
            ringView = itemView.findViewById(R.id.ring_view);
            ringView.setVisibility(View.VISIBLE);
            titleView = itemView.findViewById(R.id.chart_title);
            titleView.setVisibility(View.INVISIBLE);
            chart = itemView.findViewById(R.id.graph_container);
            chart.setVisibility(View.INVISIBLE);


        }

        public void newData(List<Entry> entries, String title) {
            ringView.setEcoValue(0.7f);
            titleView.setVisibility(View.INVISIBLE);
            chart.setVisibility(View.INVISIBLE);

        }
    }
}