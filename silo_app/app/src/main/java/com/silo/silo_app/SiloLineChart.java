package com.silo.silo_app;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;

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


public class SiloLineChart {
    private final String title;
    private final ViewGroup root;
    private final Context context;
    private List<Entry> inData;
    public LineChart chart;
    private LineDataSet dataSet;
    private LineData data;

    SiloLineChart(String title, String descCont, List<Entry> inData, ViewGroup root, Context context) {
        this.title = title;
        this.root = root;
        this.context = context;
        this.inData = inData;
        chart = new LineChart(context);
        chart.setHardwareAccelerationEnabled(true);
        root.addView(chart);

        dataSet = new LineDataSet(this.inData, title);
        dataSet.setColor(context.getColor(R.color.graph_label));
        dataSet.setLineWidth(4);
        //dataSet.setDrawCubic()
        dataSet.setCircleColor(context.getColor(R.color.graph_line));
        dataSet.setDrawCircles(false);
        dataSet.setDrawValues(false);
        dataSet.setDrawHighlightIndicators(false);
        dataSet.setFillColor(Color.BLUE);
        dataSet.setDrawFilled(true);
        dataSet.setCubicIntensity(1);
        data = new LineData(dataSet);

        chart.setData(data);
        chart.setBackgroundColor(context.getColor(R.color.graph_back));
        Description desc = new Description();
        desc.setText(descCont);
      //  desc.setTextColor(context.);
        chart.setPadding(10,10,10,10);
        chart.setDescription(desc);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setDrawGridBackground(true);
        chart.setDrawBorders(true);
        chart.setDrawMarkers(false);
        chart.setMinimumHeight((int) context.getResources().getDimension(R.dimen.graph_height));
        chart.setMinimumWidth((int) context.getResources().getDimension(R.dimen.graph_width));


        /*chart.setHighlighter(new ChartHighlighter() {

        });
        */
        chart.setHighlightPerDragEnabled(true);
        chart.setHighlightPerTapEnabled(true);

        chart.getAxisRight().setEnabled(false);
        YAxis y = chart.getAxisLeft();
        XAxis x = chart.getXAxis();

        x.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return value + " AM";
            }

            @Override
            public String getPointLabel(Entry entry) {
                return entry.getX() + " AM";
            }
        });

        x.setDrawAxisLine(true);
        y.setDrawAxisLine(false);

        y.setTextSize(10);//context.getResources().getDimension(R.dimen.graph_axis));
        x.setTextSize(10);//context.getResources().getDimension(R.dimen.graph_axis));
        x.setPosition(XAxis.XAxisPosition.BOTTOM);

        x.setTextColor(context.getColor(R.color.graph_label));
        y.setTextColor(context.getColor(R.color.graph_label));

        x.setAxisLineColor(context.getColor(R.color.graph_line));
        y.setAxisLineColor(context.getColor(R.color.graph_line));

        //x.setTypeface();
        //LimitLine ave = new LimitLine() TODO

        /*chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });*/

        chart.invalidate();
    }



    public void addData(List<Entry> data) {
        this.inData.addAll(data);
    }


}
