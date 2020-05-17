package Tasks;

import Model.MonitoredData;

import java.util.LinkedList;

@FunctionalInterface
public interface Task2 {
    Integer countDistinctDays(LinkedList<MonitoredData> monitoredDataList);
}
