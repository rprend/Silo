package com.silo.silo_app;

import android.content.Context;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SiloPieChart extends SiloChart {


    SiloPieChart(ViewGroup root, Context context) {
        super(context);
        chart = new PieChart(context);
        root.addView(chart);
        makeChart(chart);
        //  this.root = root;

        chart.invalidate();
    }


    public void newData(List<Entry> nData, String title) {

        Class<PieEntry> pClass = PieEntry.class;
        List<PieEntry> pieEntries = nData.stream().map(pClass::cast).collect(Collectors.toList());

        PieDataSet dataSet = new PieDataSet(pieEntries, title);
        dataSet.setColor(context.getColor(R.color.graph_line));

        dataSet.setDrawValues(false);

        PieData data = new PieData(dataSet);

        chart.setData(data);
        chart.getLegend().setEnabled(true);

        chart.animateX(1000, Easing.Linear);
        //chart.invalidate();
    }


}
