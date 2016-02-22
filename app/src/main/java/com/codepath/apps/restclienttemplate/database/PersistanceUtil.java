package com.codepath.apps.restclienttemplate.database;

import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.codepath.apps.restclienttemplate.models.Media;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

/**
 * Created by skammila on 2/20/16.
 */
public class PersistanceUtil {

    public static void persistTweets(List<Tweet> tweets) {
        int count = new Select().from(Tweet.class).count();
        Log.i("INFO", "Tweet Count: " + count);
        if (count >= 100) {
            new Delete().from(Tweet.class).execute();
        }
        ActiveAndroid.beginTransaction();
        try{
            for(Tweet tweet : tweets) {
                tweet.getUser().save();
                tweet.save();
                List<Media> medias = tweet.getEntities().getMedia();
                for (Media m: medias) {
                    m.save();
                }

                tweet.getEntities().save();
            }
            ActiveAndroid.setTransactionSuccessful();

        } finally {
            ActiveAndroid.endTransaction();
        }

    }
}
