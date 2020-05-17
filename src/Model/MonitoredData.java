package Model;

import java.sql.Timestamp;

public class MonitoredData {
    private Timestamp startTime;
    private Timestamp endTime;
    private String activity;

    public MonitoredData(Timestamp startTime, Timestamp endTime, String activity) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Integer getDistinctStartDay(){
        return startTime.toLocalDateTime().getMonthValue()*31+startTime.toLocalDateTime().getDayOfMonth();
    }
    public Integer getDistinctEndDay(){
        return endTime.toLocalDateTime().getMonthValue()*31+endTime.toLocalDateTime().getDayOfMonth();
    }

    public Long computeActivityTime(){
        return endTime.getTime()-startTime.getTime();
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public String getActivity() {
        return activity;
    }

}
