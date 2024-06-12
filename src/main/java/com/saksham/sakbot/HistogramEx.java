//package com.saksham.sakbot;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtils;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//
//import java.awt.*;
//import java.io.File;
//
//public class HistogramEx {
//    public static File makeGraph(String fileName, double[] point, double[] point2){
//        XYSeries a = new XYSeries("a");
//        a.add(point[0], point[1]);
//        a.add(point2[0], point2[1]);
//        XYSeriesCollection dataset = new XYSeriesCollection();
//        dataset.addSeries(a);
//        JFreeChart xylineChart = ChartFactory.createXYLineChart("", "", "", dataset);
//
//        xylineChart.getPlot().setOutlinePaint(Color.blue);
//        File file = new File(fileName);
//        try{
//            ChartUtils.saveChartAsPNG(file, xylineChart, 1000, 1000);
//        }catch (Exception ignored){
//
//        }
//        return file;
//    }
//}
