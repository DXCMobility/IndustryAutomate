package fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import example.com.industrialautomation.R;

import java.util.ArrayList;




public class ScreenSlidePageFragment extends Fragment {
    BarChart barChart;
    LineChart lineChart;
    PieChart pieChart ;
    LineChart predLineChart ;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

       // chart = (BarChart)view.findViewById(R.id.costChart);
        barChart = (BarChart)view.findViewById(R.id.costChart);
        lineChart = (LineChart)view.findViewById(R.id.lineChart);
        pieChart = (PieChart) view.findViewById(R.id.piChart);
        predLineChart = (LineChart)view.findViewById(R.id.predictAnalysisChart);

        barChartInit();
        lineChartInit();
        pieChartInit();
        predLineChartInit();

        return view;

    }

    private void pieChartInit() {

        ArrayList<Entry> entries = new ArrayList<>();
                entries.add(new Entry(20, 0));
                entries.add(new Entry(40, 1));
                entries.add(new Entry(15, 2));
                entries.add(new Entry(25, 3));

        PieDataSet dataset = new PieDataSet(entries, "");

        // creating labels<br />
        ArrayList<String> labels = new ArrayList<String>();
                labels.add("Quarter 1");
                labels.add("Quarter 2");
                labels.add("Quarter 3");
                labels.add("Quarter 4");


        PieData data = new PieData(labels, dataset);
        pieChart.setUsePercentValues(true);
        pieChart.setData(data);

        pieChart.setDescription(" Quarterly Revenue (%)");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateY(5000);

    }

    private void lineChartInit() {

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(18f, 4));

        LineDataSet dataset = new LineDataSet(entries,"Days in a month");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("1");
        labels.add("2");
        labels.add("3");
        labels.add("4");
        labels.add("5");
        labels.add("6");


        LineData data = new LineData(labels, dataset);
        lineChart.setData(data); // set the data and list of lables into chart
        lineChart.setDescription("Machine Downtime");
        dataset.setDrawFilled(true); // to fill the below area of line in graph
       // dataset.setColors(ColorTemplate.COLORFUL_COLORS); // to change the color scheme

    }


    private void predLineChartInit() {

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(5f, 0));
        entries.add(new Entry(10f, 1));
        entries.add(new Entry(15f, 2));
        entries.add(new Entry(20f, 3));
        entries.add(new Entry(25f, 4));

        LineDataSet dataset = new LineDataSet(entries,"Predictive Analysis");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("1");
        labels.add("2");
        labels.add("3");
        labels.add("4");
        labels.add("5");



        LineData data = new LineData(labels, dataset);
        predLineChart.setData(data); // set the data and list of lables into chart
        predLineChart.setDescription("Analysis");
        dataset.setDrawFilled(true); // to fill the below area of line in graph
        // dataset.setColors(ColorTemplate.COLORFUL_COLORS); // to change the color scheme

    }

    public void barChartInit(){

       // String[] xAxisLabels={"Assembly Line","Fan","Load","Cooling System"};
        BarData data = new BarData(getXAxisValues(), getDataSet());
        barChart.setData(data);
        barChart.setDescription("Overall Performance");
        barChart.animateXY(2000, 2000);
        barChart.invalidate();

    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Assembly Line
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Fan
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Load
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Cooling System
        valueSet1.add(v1e4);


        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "AL");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);

        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("Assembly Line");
        xAxis.add("Fan");
        xAxis.add("Load");
        xAxis.add("Cooling System");

        return xAxis;
    }

    private ArrayList<BarDataSet> getDataSet(float[] plot1, float[] plot2) {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        for(int i=0;i<plot1.length;i++){
            valueSet1.add(new BarEntry(plot1[i],i));
        }


        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        for(int i=0;i<plot2.length;i++){
            valueSet2.add(new BarEntry(plot2[i],i));
        }


        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "2015");
        barDataSet1.setColor(Color.parseColor("#5BC1CD"));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "2016");
        barDataSet2.setColor(Color.parseColor("#9E1600"));

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues(String[] arrayName) {
        ArrayList<String> xAxis = new ArrayList<>();
        for (int i=0;i<arrayName.length;i++){
            xAxis.add(arrayName[i]);
        }


        return xAxis;
    }


    }
