package com.nolostcalls.intelligentcallrecording.Expandable_listView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

class SlideExpandableListView extends ListView {
    private SlideExpandableListAdapter adapter;

    public SlideExpandableListView(Context context) {
        super(context);
    }

    public SlideExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean collapse() {
        if (adapter != null) {
            return adapter.collapseLastOpen();
        }
        return false;
    }

    public void setAdapter(ListAdapter adapter) {
        this.adapter = new SlideExpandableListAdapter(adapter);
        super.setAdapter(this.adapter);
    }

    public void setAdapter(ListAdapter adapter, int toggle_button_id, int expandable_view_id) {
        this.adapter = new SlideExpandableListAdapter(adapter, toggle_button_id, expandable_view_id);
        super.setAdapter(this.adapter);
    }


    public void enableExpandOnItemClick() {
        this.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapter != null) {
                    adapter.getExpandToggleButton(view).performClick();
                }
            }
        });
    }


    @Override
    public Parcelable onSaveInstanceState() {
        return adapter.onSaveInstanceState(super.onSaveInstanceState());
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof AbstractSlideExpandableListAdapter.SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        AbstractSlideExpandableListAdapter.SavedState ss = (AbstractSlideExpandableListAdapter.SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        if (adapter != null) {
            adapter.onRestoreInstanceState(ss);
        }
    }
}
