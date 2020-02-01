package com.silo.silo_app;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

public class SiloFormatters {
    public class TimeDay extends ValueFormatter {
        @Override
        public String getAxisLabel(float value, AxisBase axis) {
            return value + " sec";
        }
    }
}