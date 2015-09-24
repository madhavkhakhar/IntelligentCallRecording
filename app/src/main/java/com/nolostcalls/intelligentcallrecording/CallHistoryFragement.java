package com.nolostcalls.intelligentcallrecording;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nolostcalls.intelligentcallrecording.Expandable_listView.ActionSlideExpandableListView;

import java.util.ArrayList;

/**
 * Created by Android on 9/22/2015.
 */
public class CallHistoryFragement extends Fragment {

    ActionSlideExpandableListView listView;
    private ListAdapter adapter;
    private ArrayList<ListItem> listItems;
    public CallHistoryFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_call_history, container, false);

        listView = (ActionSlideExpandableListView) rootView.findViewById(R.id.historyList);

        /*listView = (ListView)findViewById(R.id.historyList);
*/
        listItems = new ArrayList<ListItem>();

        listItems.add(new ListItem("Hiren", "00:22:16", 1, "Wed 01/08/2015", "4:50 PM", "+911234567890", android.R.drawable.ic_input_add, "00:10", "Jane"));

        listItems.add(new ListItem("Hiren", "00:22:16", 1, "Wed 01/08/2015", "4:50 PM", "+911234567890", android.R.drawable.ic_btn_speak_now, "00:10", "Jane"));

        listItems.add(new ListItem("Madhav", "00:22:16", 9, "Wed 01/08/2015", "4:50 PM", "+911234567892", android.R.drawable.ic_input_add, "00:10", "Jon"));

        listItems.add(new ListItem("Mayur", "00:22:16", 2, "Wed 01/08/2015", "4:50 PM", "+911234567895", android.R.drawable.ic_btn_speak_now, "00:15", "Jeniffer"));

        adapter = new ListAdapter(getActivity(),
                listItems);
        listView.setAdapter(adapter);

        listView.setItemActionListener(new ActionSlideExpandableListView.OnActionClickListener() {

            @Override
            public void onClick(View listView, View buttonview, int position) {

     /*           String actionName = "";
                if(buttonview.getId()==R.id.buttonA) {
                    actionName = "buttonA";

                } else {
                    actionName = "ButtonB";
                }

                Toast.makeText(
                        ExampleActivity.this,
                        "Clicked Action: " + actionName + " in list item " + position,
                        Toast.LENGTH_SHORT
                ).show();
            }

            // note that we also add 1 or more ids to the setItemActionListener
            // this is needed in order for the listview to discover the buttons
        }, R.id.buttonA, R.id.buttonB);
    }*/
            }

        });



    // Inflate the layout for this fragment
        return rootView;

}

}
