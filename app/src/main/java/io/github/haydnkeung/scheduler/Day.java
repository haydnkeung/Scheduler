package io.github.haydnkeung.scheduler;

import java.util.ArrayList;

public class Day {

    private ArrayList<MyEvent> eventList;
    private int year;
    private int month;
    private int day;


    public Day(int year, int month, int day, MyEvent event){
        this.year = year;
        this.month = month;
        this.day = day;
        eventList = new ArrayList<>();
        eventList.add(event);
    }

    public Day(int year, int month, int day, ArrayList<MyEvent> inputlist){
        this.year = year;
        this.month = month;
        this.day = day;
        eventList = new ArrayList<>();
        for(MyEvent e : inputlist){
            eventList.add(e);
        }
    }

    public ArrayList<MyEvent> toList(){
        return eventList;
    }

    public String getDate() {
        String month = String.format("%02d", this.month);
        String day = String.format("%02d", this.day);
        String year = String.format("%04d", (this.year+2019));
        return month + "-" + day + "-" + year;
    }


    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        for(int i = 0; i < eventList.size();i++){
            eventList.get(i).setDate(year,month,day);
        }
    }

    public int eventCount(){
        return eventList.size();
    }

    public MyEvent itemAt(int x){
        return eventList.get(x);
    }

    public void addEvent(MyEvent input){
        eventList.add(input);
    }



}
