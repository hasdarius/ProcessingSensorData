package Main;

import Controller.Controller;
import Model.MonitoredData;
import Printer.MyPrinter;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        LinkedList<MonitoredData> monitoredDataList = controller.solveTask1("Activities.txt");
        MyPrinter printer=new MyPrinter();
        printer.printTask1(monitoredDataList);
        printer.printTask2(controller.solveTask2(monitoredDataList));
        printer.printTask3(controller.solveTask3(monitoredDataList));
        printer.printTask4(controller.solveTask4(monitoredDataList));
        printer.printTask5(controller.solveTask5(monitoredDataList));
        printer.printTask6(controller.solveTask6(monitoredDataList));
    }
}
