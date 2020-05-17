package Tasks;

import Model.MonitoredData;

import java.util.LinkedList;
import java.util.Map;

@FunctionalInterface
public interface Task4 {
    Map<Integer, Map<String,Integer>> countOccurencePerDays(LinkedList<MonitoredData> monitoredDataList);

}
