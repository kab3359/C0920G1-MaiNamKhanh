package session_4.bai_tap;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;
    public StopWatch (LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public StopWatch() {
        startTime = LocalTime.now();
    }
    public void start(){
        this.startTime = LocalTime.now();
    }
    public void stop() {
        this.endTime = LocalTime.now();
    }
    public void getElapsedTime(){
        int miliSecond = ((endTime.getHour()-startTime.getHour())*3600 + (endTime.getMinute()-startTime.getMinute())*60 + (endTime.getSecond()-startTime.getSecond())*1000);
        System.out.println("Số mili giây đếm đc:" + miliSecond);
    }
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Đang đếm thời gian");
        for (int i = 1; i <= 100000; i++) {
            stopWatch.stop();
            stopWatch.getElapsedTime();
        }
    }
}
