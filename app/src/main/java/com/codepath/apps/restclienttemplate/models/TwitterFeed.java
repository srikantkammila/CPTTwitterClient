package com.codepath.apps.restclienttemplate.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skammila on 2/18/16.
 */
public class TwitterFeed {
    List<Tweet> tweets;

    public TwitterFeed() {
        this.tweets = new ArrayList<Tweet>();
    }


    public static TwitterFeed parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        TwitterFeed twitterFeed = gson.fromJson(response, TwitterFeed.class);
        return twitterFeed;
    }
}
