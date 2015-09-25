package com.nolostcalls.intelligentcallrecording;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Android on 9/22/2015.
 */
public class CallHistoryFragement extends Fragment {

    ExpandableListView expListView;
    private List<ListItem> listItems;
    private HashMap<ListItem, List<String>> listDataChild;
    ExpandableListAdapter listAdapter;


    public CallHistoryFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_call_history, container, false);

        expListView = (ExpandableListView) rootView.findViewById(R.id.historyList);

        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listItems, listDataChild);
        expListView.setAdapter(listAdapter);


        return rootView;

    }

    public void prepareListData(){
        listItems = new ArrayList<ListItem>();
        listDataChild = new HashMap<ListItem, List<String>>();

        listItems.add(new ListItem("Hiren", "00:22:16", 1, "Wed 01/08/2015", "4:50 PM", "+911234567890", android.R.drawable.ic_input_add, "00:10", "Jane"));

        listItems.add(new ListItem("Hiren", "00:22:16", 1, "Wed 01/08/2015", "4:50 PM", "+911234567890", android.R.drawable.ic_btn_speak_now, "00:10", "Jane"));

        listItems.add(new ListItem("Madhav", "00:22:16", 9, "Wed 01/08/2015", "4:50 PM", "+911234567892", android.R.drawable.ic_input_add, "00:10", "Jon"));

        listItems.add(new ListItem("Mayur", "00:22:16", 2, "Wed 01/08/2015", "4:50 PM", "+911234567895", android.R.drawable.ic_btn_speak_now, "00:15", "Jeniffer"));

        ArrayList<String> l = new ArrayList<>();
        l.add("a");
        listDataChild.put(listItems.get(0), l);
        listDataChild.put(listItems.get(1), l);
        listDataChild.put(listItems.get(2), l);

    }

}
