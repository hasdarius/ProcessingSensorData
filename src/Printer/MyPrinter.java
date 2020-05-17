package Printer;

import Controller.Controller;
import Model.MonitoredData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyPrinter {

    public void printTask1(LinkedList<MonitoredData> monitoredDataList){
        StringBuilder stringBuilder=new StringBuilder();
        monitoredDataList.forEach(monitoredData -> {
            stringBuilder.append(monitoredData.getStartTime()).append("\t").append(monitoredData.getEndTime()).append("\t").append(monitoredData.getActivity()).append("\n");
        });
        generateFile("task1.txt",stringBuilder.toString());
    }
    public void printTask2(Integer integer){
        generateFile("task2.txt","The number of distict days that appear in the monitoring data is: "+ integer);
    }
    public void printTask3(Map<String, Integer> occurenceMap){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Number of occurence for each activity during the monitoring time:").append("\n");
        occurenceMap.forEach((key, value) -> {
           stringBuilder.append(key).append(" has happened ").append(value).append(" time(s).").append("\n");
        });
        generateFile("task3.txt",stringBuilder.toString());
    }
    public void printTask4(Map<Integer, Map<String, Integer>> task){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Number of occurence for each activity in each day:").append("\n\n");
        task.forEach((key,value)->{
            stringBuilder.append("Day: ").append(key).append("\n");
            value.forEach((key2,value2)->{
                stringBuilder.append(key2).append(" has happened ").append(value2).append(" time(s).").append("\n");
            });
            stringBuilder.append("\n");
        });
        generateFile("task4.txt",stringBuilder.toString());
    }
    public void printTask5(Map<String, LocalDateTime> totalTimeMap){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("These are the entire durations for each activity throughout the monitoring data period:").append("\n");
        totalTimeMap.forEach((key, value) -> {
            stringBuilder.append(key).append(" has a total time of: ").append(value.getDayOfMonth()-1).append(" days and ").append(value.toLocalTime()).append(" hours.").append("\n");
        });
        generateFile("task5.txt",stringBuilder.toString());
    }
    public void printTask6(List<String> filteredActivitiesList){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("These are the activities that have more than 90% of the monitoring records with duration less than 5 minutes:").append("\n");
        filteredActivitiesList.forEach(string->{
            stringBuilder.append(string).append("\n");
        });
        generateFile("task6.txt",stringBuilder.toString());
    }
    
    public void generateFile(String fileName, String whatToWrite){
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(fileName));
            myWriter.write(whatToWrite);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
