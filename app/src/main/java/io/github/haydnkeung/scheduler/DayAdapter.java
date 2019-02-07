package io.github.haydnkeung.scheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class DayAdapter extends ArrayAdapter<Day> {


    public DayAdapter(Context context, int resource, ArrayList<Day> myDay) {
        //Passed in 0 as resource since it is not used, instead we will inflate the view
        //ourselves in the getView method i.e create custom adapter
        super(context, 0, myDay);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        //if does not already have a view being recycled create new one, else recycle it to save memory
        if (null == listItemView) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Day currentDay = getItem(position);

        TextView taskTitle = listItemView.findViewById(R.id.taskName);
        taskTitle.setText(currentDay.getDate());

        TextView taskDate = listItemView.findViewById(R.id.taskDate);
        taskDate.setText("There are "+currentDay.eventCount()+ " tasks scheduled on "+currentDay.getDate());

        return listItemView;

    }

}
