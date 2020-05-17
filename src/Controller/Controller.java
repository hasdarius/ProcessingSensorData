package Controller;

import Model.MonitoredData;
import Tasks.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

public class Controller {

    public LinkedList<MonitoredData> solveTask1(String fileToReadFrom) {
        Task1 task1 = (fileName) -> {
            LinkedList<MonitoredData> monitoredDataList = new LinkedList<>();
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                stream.forEach((line) -> {
                    String[] arguments = line.split("\\t+");
                    monitoredDataList.add(new MonitoredData(Timestamp.valueOf(arguments[0]), Timestamp.valueOf(arguments[1]), arguments[2]));
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return monitoredDataList;
        };
        return task1.readFile(fileToReadFrom);
    }

    public Integer solveTask2(LinkedList<MonitoredData> monitoredDataList) {
        Task2 task2 = (list) -> {
            LinkedHashSet<Integer> days = new LinkedHashSet<>();
            list.forEach((monitoredData -> {
                days.add(monitoredData.getDistinctStartDay());
                days.add(monitoredData.getDistinctEndDay());
            }));
            return days.size();
        };
        return task2.countDistinctDays(monitoredDataList);
    }

    public Map<String, Integer> solveTask3(LinkedList<MonitoredData> monitoredDataList) {
        Task3 task3 = (list) -> {
            Map<String, Integer> occurenceMap = new HashMap<>();
            list.forEach((monitoredData -> {
                occurenceMap.put(monitoredData.getActivity(), occurenceMap.getOrDefault(monitoredData.getActivity(), 0) + 1);
            }));
            return occurenceMap;
        };
        return task3.countActivityOccurence(monitoredDataList);
    }

    public Map<Integer, Map<String, Integer>> solveTask4(LinkedList<MonitoredData> monitoredDataList) {
        Task4 task4 = (list) -> {
            Map<Integer, Map<String, Integer>> occurenceMap = new HashMap<>();
            list.forEach((monitoredData -> {
                occurenceMap.put(monitoredData.getStartTime().toLocalDateTime().getDayOfMonth(), occurenceMap.getOrDefault(monitoredData.getStartTime().toLocalDateTime().getDayOfMonth(), new HashMap<>()));
                occurenceMap.get(monitoredData.getStartTime().toLocalDateTime().getDayOfMonth()).put(monitoredData.getActivity(), occurenceMap.get(monitoredData.getStartTime().toLocalDateTime().getDayOfMonth()).getOrDefault(monitoredData.getActivity(), 0) + 1);
            }));
            return occurenceMap;
        };
        return task4.countOccurencePerDays(monitoredDataList);
    }

    public Map<String, LocalDateTime> solveTask5(LinkedList<MonitoredData> monitoredDataList) {
        Task5 task5 = (list) -> {
            Map<String, LocalDateTime> totalTimeMap = new HashMap<>();
            list.forEach((monitoredData -> {
                totalTimeMap.put(monitoredData.getActivity(), totalTimeMap.getOrDefault(monitoredData.getActivity(), LocalDateTime.of(0, 1, 1, 0, 0)).plus(Duration.of(monitoredData.computeActivityTime(), ChronoUnit.MILLIS)));
            }));
            return totalTimeMap;
        };
        return task5.getTotalDurationTime(monitoredDataList);
    }

    public List<String> solveTask6(LinkedList<MonitoredData> monitoredDataList) {
        Task6 task6 = (list) -> {
            Map<String, Integer> totalOccurences = this.solveTask3(list);
            List<String> filteredActivitiesList = new LinkedList<>();
            Map<String, Integer> fiveMinuteOccurences = new LinkedHashMap<>();
            list.forEach(monitoredData -> {
                int minutes = monitoredData.computeActivityTime().intValue() / 1000 / 60;
                if (minutes < 5)
                    fiveMinuteOccurences.put(monitoredData.getActivity(), fiveMinuteOccurences.getOrDefault(monitoredData.getActivity(), 0) + 1);
            });

            totalOccurences.forEach((activity, nrOfOccurences) -> {
                if (fiveMinuteOccurences.getOrDefault(activity, 0).floatValue() / nrOfOccurences.floatValue() > 0.9)
                    filteredActivitiesList.add(activity);
            });
            return filteredActivitiesList;
        };
        return task6.filterActivities(monitoredDataList);
    }
}
