package Tasks;

import Model.MonitoredData;

import java.util.LinkedList;
import java.util.Map;

@FunctionalInterface
public interface Task3 {
    Map<String, Integer> countActivityOccurence(LinkedList<MonitoredData> monitoredDataList);
}
