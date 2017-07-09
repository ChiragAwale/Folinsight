package com.chiragawale.folinsight.util;

import com.chiragawale.folinsight.entity.Follower;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by chira on 7/9/2017.
 */

public class FollowerDataUtil extends NetworkUtil {
    /**
     *
     * @param url The url that returns the JSON data of the users follower list
     * @return  list of followers extracted from the response from the server
     */
    public static List<Follower> fetchFollowerList(String url){
        URL followerDataUrl = createUrl(url);
        String jsonResponse = "";
        try {
            jsonResponse = makeHttpRequest(followerDataUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Follower> followerList = getFollowerList(jsonResponse);

        return followerList;
    }

    //Returns the list with follower objects created from data exraceted from JSON response
    private static List<Follower> getFollowerList(String jsonResponse){
        List<Follower> followerList = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(jsonResponse);
            JSONArray data = root.getJSONArray("data");
            for(int i = 0; i < data.length();i++) {
                JSONObject currentFollower = data.getJSONObject(i);
                String username = currentFollower.getString("username");
                String full_name = currentFollower.getString("full_name");
                String profilePicture_link= currentFollower.getString("profile_picture");
                int id = currentFollower.getInt("id");

                //Gets the current date
                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);
                String timezone = c.getTimeZone().getDisplayName();

                String date = month + "/" + day + "/" + year + " "+hour+":"+min + " "+timezone;

                Follower currentFollowerObject = new Follower(id,username,full_name,profilePicture_link,date,true);
                followerList.add(currentFollowerObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return followerList;
    }
}
