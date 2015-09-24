package com.nolostcalls.intelligentcallrecording;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by madhav on 13/2/15.
 */
public class ListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ListItem> listItems;

    public ListAdapter(Context context, ArrayList<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listitem, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.HistoryName);
        TextView duration = (TextView) convertView.findViewById(R.id.HistoryDuration);
        TextView lineNumber = (TextView) convertView.findViewById(R.id.HistoryLineNumber);
        TextView date = (TextView) convertView.findViewById(R.id.HistoryDate);
        TextView time = (TextView) convertView.findViewById(R.id.HistoryTime);
        TextView phoneNumber = (TextView) convertView.findViewById(R.id.HistoryPhoneNumber);
        ImageView phoneImage = (ImageView) convertView.findViewById(R.id.HistoryPhoneImage);
        TextView phoneDuration = (TextView) convertView.findViewById(R.id.DurationStart);
        TextView employeeName = (TextView) convertView.findViewById(R.id.HistoryStaffName);


        name.setText(listItems.get(position).name);
        duration.setText(listItems.get(position).duration);
        lineNumber.setText(listItems.get(position).lineNumber + "");
        date.setText(listItems.get(position).date);
        time.setText(listItems.get(position).time);
        phoneNumber.setText(listItems.get(position).phoneNumber);
        phoneImage.setImageResource(listItems.get(position).callMissed);
        phoneDuration.setText(listItems.get(position).phoneDuration);
        employeeName.setText(listItems.get(position).employeeName);


        //imgIcon.setImageResource(listItems.get(position).getIcon());
        //txtTitle.setText(listItems.get(position).getTitle());

        return convertView;
    }

}
