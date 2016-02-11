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
        infoList.add("Start from top of the Rotunda, leave your clothes and run down the lawn.  When you get to the " +
                "Homer statue, run around him three times, kiss his butt, and run back up towards the Rotunda.  Run up the steps " +
                "of the Rotunda, peek through the key hole and say 'Good evening Mr. Jefferson!'");

        titleList.add("Paint beta bridge");
        infoList.add("Get a group of friends or go with an organization, buy some spray paint or buckets and rollers and" +
                "leave an important message for the UVA community!");

        titleList.add("O'hill brunch");
        infoList.add("Relive to O'hill brunch as an upperclassmen! Get a first year to swipe you in.");

        titleList.add("Go to Trick or Treating on the Lawn");
        infoList.add("Attend the festive 'Trick or Treating on the Lawn' where a bunch of cute little kids " +
                "dress up in their Halloween costumes and get candy!");

        titleList.add("Go to a basketball game");
        infoList.add("Wear your blue and orange, make a sign, and support UVA's awesome basketball players by attending a home (or away) game at JPJ. " +
                "Go hoos!");

        titleList.add("Dress up in pearls/tie for a football game");
        infoList.add("Attend the first football game of year while wearing your whitest pearls or a nice bowtie.  You'll probably have to look up a " +
                "YouTube video on how to tie a bowtie, but it'll be worth it.");

        titleList.add("Run the 4th year 5k");
        infoList.add("Come out with a group of friends and dust off those running shoes by participating in the 4th year 5k run! The " +
                "proceeds go to the Leslie Baltz Foundation to promote healthy living and alternatives to high risk drinking. ");

        titleList.add("Sing the Good Ole Song");
        infoList.add("Join hand and hand with your fellow hoos at UVA events and sing 'The Good Ole Song', a UVA tradition! " +
                "If you don't know the lyrics, better learn them fast: \n" +
                "That good old song of Wa-hoo-wah- we'll sing them o'er and o'er \n" +
                "It cheers our hearts and warms our blood to hear them shout and roar \n" +
                "We come from old Virginia, where all is bright and gay \n" +
                "Let's all join hands and give a yell for dear old UVA \n" +
                "*Chant next part* \n"  +
                "Wa-hoo-wah, wa-hoo-wah! Uni-v, Virginia! \n" +
                "Hoo-rah-ray, hoo-rah-ray, ray, ray - UVA!");

        titleList.add("Have a picnic on the lawn");
        infoList.add("Pack a blanket, your favorite snacks (or Bodo's) and some friends to have a nice picnic on the lawn! " +
                "Enjoy beautiful cville weather!");

        titleList.add("Attend Rotunda Sing");
        infoList.add("Mark the official return to school and the start of a new year by enjoying a night of great music performed by " +
            "all your favorite UVA acapella groups on grounds! Some of the groups include the Hullabahoos, the Virginia Gentlemen, " +
            "the Virginia Belles, AVP, and many more!");

        titleList.add("Go to Lighting of the Lawn");
        infoList.add("Get in the holiday spirit right before finals by listening a UVA poem about the year and watching them light up " +
            "the lawn with christmas lights and great music!");

        titleList.add("High-five Dean Groves");
        infoList.add("If you catch Dean Groves, Associate Vice President and UVA Dean of students, around on grounds, be sure to give him a big " +
            "high-five!");

        titleList.add("Pick apples at Carter's Mountain");
        infoList.add("Enjoy the fresh air by making a trip to Carter's Mountain, 20 minutes from grouds, and picking some crisp apples and, " +
            "of course, indulging in the delicious apple cider donuts!");

        titleList.add("Pull an all-nighter at Clem");
        infoList.add("Lose your soul while staying up all night to study for a class that you blew off all semester in the dungeon " +
            "that is first floor clem (what we affectionately call Clemons Library).");

        titleList.add("Eat at Pancakes for Parkinson's");
        infoList.add("The best way to tailgate the UVA Homecoming  game is to enjoy delicious pancakes on the lawn cooked by your fellow Hoos! ");

        titleList.add("Volunteer through Madison House");
        infoList.add("Make a difference here at UVA or even in the cville community by volunteering through Madison House, the " +
            "volunteer center here at UVA.");

        titleList.add("Do a sunrise hike at Humpback Mountain");
        infoList.add("Get up at 5 am and hike up Humpback Mountain to see the sunrise and a beautiful view of Charlottesville that you " +
            "can't miss!");

        titleList.add("Carve a pumpkin at puppies and pumpkins");
        infoList.add("Go down to the amphitheater to see cute puppies and carve a pumpkin to get enjoy the beautiful fall season!");

        titleList.add("Eat at Duck Donuts");
        infoList.add("Enjoy the DELICIOUS donuts, freshly made with all kinds of great flavors, at Duck Donuts, just down 29 by Trader Joe's!");


        for (int i = 0; i < titleList.size(); i++) {
            completedList.add(false);
        }
    }
}
