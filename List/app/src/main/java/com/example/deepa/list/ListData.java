package com.example.deepa.list;

import java.util.ArrayList;

/**
 * Created by Deepa on 2/10/16.
 */
public class ListData {
    private static ArrayList<String> titleList;
    private static ArrayList<String> infoList;
    private static ArrayList<Boolean> completedList;

    public static ArrayList<String> getTitleList() { return titleList; }
    public static ArrayList<String> getInfoList() { return infoList; }
    public static ArrayList<Boolean> getCompletedList() { return completedList; }

    public static void setCompleted(int index, boolean completed) { completedList.set(index, completed); }
    
    public static void initializeListData() {
        titleList = new ArrayList<String>();
        infoList = new ArrayList<String>();
        completedList = new ArrayList<Boolean>();

        titleList.add("Get the number 1 ticket at Bodo's");
        infoList.add("Wake up early and go to Bodo's at 6 AM or else you will be too late. Good luck!");

        titleList.add("Streak the lawn");
        infoList.add("Start from the Rotunda, leave your clothes and run down the lawn ");

        titleList.add("Paint beta bridge");

        titleList.add("O'hill brunch");

        titleList.add("Go to Trick or Treating on the Lawn");

        titleList.add("Go to a basketball game");

        titleList.add("Dress up in pearls/tie for a football game");

        titleList.add("Go inside the Rotunda");

        titleList.add("Sing the Good Ole Song");

        titleList.add("Have a picnic on the lawn");

        titleList.add("Attend Rotunda Sing");

        titleList.add("Go to Lighting of the Lawn");

        titleList.add("High-five Dean Groves");

        titleList.add("Pick apples at Carter's Mountain");

        titleList.add("Pull an all-nighter at Clem");

        titleList.add("Eat at Pancakes for Parkinson's");

        titleList.add("Volunteer through Madison House");

        titleList.add("Do a sunrise hike at Humpback Mountain");

        titleList.add("Visit Carr's Hill");

        titleList.add("Get a job");

        for (int i = 0; i < titleList.size(); i++) {
            completedList.add(false);
        }
    }
}
