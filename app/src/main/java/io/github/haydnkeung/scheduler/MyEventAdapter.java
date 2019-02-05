package io.github.haydnkeung.scheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyEventAdapter extends ArrayAdapter<MyEvent> {


    public MyEventAdapter(Context context, int resource, ArrayList<MyEvent> myEvents) {
        //Passed in 0 as resource since it is not used, instead we will inflate the view
        //ourselves in the getView method i.e create custom adapter
        super(context, 0, myEvents);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        //if does not already have a view being recycled create new one, else recycle it to save memory
        if (null == listItemView) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        MyEvent currentMyEvent = getItem(position);

        TextView taskTitle = listItemView.findViewById(R.id.taskName);
        taskTitle.setText(currentMyEvent.getEventName());

        TextView taskDate = listItemView.findViewById(R.id.taskDate);
        taskDate.setText(currentMyEvent.getDate());

        return listItemView;

    }
}
