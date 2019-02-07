package io.github.haydnkeung.scheduler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;

public class DaysMap {


    private static HashMap<String,Day> map = new HashMap<>();
    private static ArrayList<String> keySet = new ArrayList<>();


    private static String getKey(int year, int month, int day){
        return Integer.toString(year)+Integer.toString(month)+Integer.toString(day);
    }

    //*probably returns null of !found* Verify later
    public static Day getDay(int year, int month, int day){
        String key = getKey(year,month,day);
        return map.get(key);
    }
    public static ArrayList<Day> toList(){
        ArrayList<Day> list = new ArrayList<>();
        for(int i = 0; i < keySet.size();i++){
            list.add(map.get(keySet.get(i)));
        }
        return list;
    }

    //Removes old day and replaces it with new one. Careful!!!
    //plz call getKey to format key before calling
    public static void updateMap(Day day, String key){
        if(!key.contains("-")){
            System.out.println("Illegal Key");
            System.exit(1);
        }
        if(map.containsKey(key)){
            map.remove(key);
        }
        keySet.add(key);
        map.put(key,day);
    }

}
