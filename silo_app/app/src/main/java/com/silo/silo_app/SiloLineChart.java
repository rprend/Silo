package com.silo.silo_app;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.List;


public class SiloLineChart extends SiloChart{
    //private final ViewGroup root;


    SiloLineChart(ViewGroup root, Context context) {
        super(context);
        chart = new LineChart(context);
        root.addView(chart);
        makeChart(chart);
      //  this.root = root;

        chart.invalidate();
    }


    public void newData(List<Entry> nData, String title) {

        ((LineChart)chart).getAxisRight().setEnabled(false);
        YAxis y = ((LineChart)chart).getAxisLeft();
        XAxis x = chart.getXAxis();

        x.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return value + "";
            }

            @Override
            public String getPointLabel(Entry entry) {
                return entry.getX() + "";
            }
        });

        x.setDrawAxisLine(true);
        x.setAxisLineWidth(1);
        y.setDrawAxisLine(true);
        y.setAxisLineWidth(1);
        y.setTextSize(12);//context.getResources().getDimension(R.dimen.graph_axis));
        x.setTextSize(10);//context.getResources().getDimension(R.dimen.graph_axis));
        x.setPosition(XAxis.XAxisPosition.BOTTOM);

        x.setTextColor(context.getColor(R.color.graph_label));
        y.setTextColor(context.getColor(R.color.graph_label));

        x.setAxisLineColor(context.getColor(R.color.green));
        y.setAxisLineColor(context.getColor(R.color.green));

        x.setDrawGridLines(false);
        y.setDrawGridLines(false);


        ((LineChart)chart).setDrawGridBackground(false);
        ((LineChart)chart).setDrawBorders(false);

        LineDataSet dataSet = new LineDataSet(nData, title);
        dataSet.setColor(context.getColor(R.color.graph_line));
        dataSet.setLineWidth(4);
        //dataSet.setDrawCubic()
        dataSet.setCircleColor(context.getColor(R.color.graph_line));
        dataSet.setDrawCircles(false);
        dataSet.setDrawValues(false);
        dataSet.setDrawHighlightIndicators(false);
        dataSet.setFillColor(context.getColor(R.color.green));
        dataSet.setDrawFilled(true);
        dataSet.setCubicIntensity(1);
        LineData data = new LineData(dataSet);

        chart.setData(data);
        chart.animateX(1000, Easing.Linear);
        //chart.invalidate();
    }


}
