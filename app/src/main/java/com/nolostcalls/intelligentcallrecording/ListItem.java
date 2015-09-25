package com.nolostcalls.intelligentcallrecording;

/**
 * Created by madhav on 13/2/15.
 */
public class ListItem {
    public String name;
    public String duration;
    public int lineNumber;
    public String date;
    public String time;
    public String phoneNumber;
    public int callMissed;
    public String phoneDuration;
    public String employeeName;

    public ListItem() {
    }

    public ListItem(String name, String duration, int lineNumber, String date, String time, String phoneNumber, int callMissed,
                    String phoneDuration, String employeeName) {
        this.name = name;
        this.duration = duration;
        this.lineNumber = lineNumber;
        this.date = date;
        this.time = time;
        this.phoneNumber = phoneNumber;
        this.callMissed = callMissed;
        this.phoneDuration = phoneDuration;
        this.employeeName = employeeName;
    }

    /*public ListItem(String title, int icon, boolean isCounterVisible, String count){
        this.title = title;
        this.icon = icon;
    }*/

    /*public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }



    public void setTitle(String title){
        this.title = title;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }*/

}
