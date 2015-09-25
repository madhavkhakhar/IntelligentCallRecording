package com.nolostcalls.intelligentcallrecording;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.HashMap;
import java.util.List;

/**
 * Created by madhav on 25/9/15.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<ListItem> listItems; // header titles
    // child data in format of header title, child title
    private HashMap<ListItem, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<ListItem> listDataHeader, HashMap<ListItem, List<String>> listChildData) {
        this._context = context;
        this.listItems = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this.listItems.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        //final String childText = (String) getChild(groupPosition, childPosition);

            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.listitem_child, parent, false);

        //TextView txtListChild = (TextView) convertView
          //      .findViewById(R.id.lblListItem);

        //txtListChild.setText(childText);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return _listDataChild.get(listItems.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listItems.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listItems.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int position, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        ListItem groupItem = (ListItem) getGroup(position);
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.listitem, parent, false);


        TextView name = (TextView) convertView.findViewById(R.id.HistoryName);
        TextView duration = (TextView) convertView.findViewById(R.id.HistoryDuration);
        TextView lineNumber = (TextView) convertView.findViewById(R.id.HistoryLineNumber);
        TextView date = (TextView) convertView.findViewById(R.id.HistoryDate);
        TextView time = (TextView) convertView.findViewById(R.id.HistoryTime);
        TextView phoneNumber = (TextView) convertView.findViewById(R.id.HistoryPhoneNumber);
        ImageView phoneImage = (ImageView) convertView.findViewById(R.id.HistoryPhoneImage);
        TextView phoneDuration = (TextView) convertView.findViewById(R.id.DurationStart);
        TextView employeeName = (TextView) convertView.findViewById(R.id.HistoryStaffName);


        name.setText(groupItem.name);
        duration.setText(groupItem.duration);
        lineNumber.setText(groupItem.lineNumber + "");
        date.setText(groupItem.date);
        time.setText(groupItem.time);
        phoneNumber.setText(groupItem.phoneNumber);
        phoneImage.setImageResource(groupItem.callMissed);
        phoneDuration.setText(groupItem.phoneDuration);
        employeeName.setText(groupItem.employeeName);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
