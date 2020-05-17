package Tasks;

import Model.MonitoredData;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Map;

@FunctionalInterface
public interface Task5 {
    Map<String, LocalDateTime> getTotalDurationTime(LinkedList<MonitoredData> monitoredDataList);
}
