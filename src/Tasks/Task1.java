package Tasks;

import Model.MonitoredData;

import java.util.LinkedList;

@FunctionalInterface
public interface Task1 {
    LinkedList<MonitoredData> readFile(String fileName);
}
