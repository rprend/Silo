package com.silo.silo_app;


import android.content.Context;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.List;

public abstract class SiloChart {
    //private final ViewGroup root;
    public final Context context;
    public Chart chart;
    //public DataSet dataSet;
    //public LineData data;

    SiloChart(Context context) {

        //  this.root = root;
        this.context = context;

    }

    public void makeChart(Chart root) {
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

        chart.setDrawMarkers(false);
        //chart.setMinimumHeight((int) context.getResources().getDimension(R.dimen.graph_height));
        //  chart.setMinimumHeight((int) context.getResources().getDimension(R.dimen.graph_height));
        // chart.setMinimumWidth((int) context.getResources().getDimension(R.dimen.graph_width));


        /*chart.setHighlighter(new ChartHighlighter() {

        });
        */
        //chart.setHighlightPerDragEnabled(true);
        //chart.setHighlightPerTapEnabled(true);


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

    public abstract void newData(List<Entry> nData, String title);


}
