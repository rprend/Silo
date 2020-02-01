package com.silo.silo_app;

import android.content.Context;
import android.graphics.Color;
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


public class SiloLineChart {
    //private final ViewGroup root;
    private final Context context;
    public LineChart chart;
    private LineDataSet dataSet;
    private LineData data;

    SiloLineChart(LineChart root, Context context) {

      //  this.root = root;
        this.context = context;
        chart = root;
        chart.setHardwareAccelerationEnabled(true);


        chart.setBackgroundColor(context.getColor(R.color.graph_back));
        //Description desc = new Description();
       // desc.setText(descCont);
      //  desc.setTextColor(context.);
       // chart.setPadding(10,10,10,100);
      //  chart.setDescription(desc);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setDrawBorders(false);
        chart.setDrawMarkers(false);
      //  chart.setMinimumHeight((int) context.getResources().getDimension(R.dimen.graph_height));
       // chart.setMinimumWidth((int) context.getResources().getDimension(R.dimen.graph_width));


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
        x.setAxisLineWidth(1);
        y.setDrawAxisLine(true);
        y.setAxisLineWidth(1);
        y.setTextSize(12);//context.getResources().getDimension(R.dimen.graph_axis));
        x.setTextSize(12);//context.getResources().getDimension(R.dimen.graph_axis));
        x.setPosition(XAxis.XAxisPosition.BOTTOM);

        x.setTextColor(context.getColor(R.color.graph_label));
        y.setTextColor(context.getColor(R.color.graph_label));

        x.setAxisLineColor(context.getColor(R.color.green));
        y.setAxisLineColor(context.getColor(R.color.green));

        x.setDrawGridLines(false);
        y.setDrawGridLines(false);

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


    public void newData(List<Entry> nData, String title) {

        dataSet = new LineDataSet(nData, title);
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
        data = new LineData(dataSet);

        chart.setData(data);
        chart.animateX(1000, Easing.EaseInExpo);
        //chart.invalidate();
    }


}
