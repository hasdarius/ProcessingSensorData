package Tasks;

import Model.MonitoredData;

import java.util.LinkedList;
import java.util.List;

@FunctionalInterface
public interface Task6 {
    List<String> filterActivities(LinkedList<MonitoredData> monitoredDataList);
}
