package com.codepath.apps.restclienttemplate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.models.Media;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skammila on 2/18/16.
 */
public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    List<Tweet> tweets;

    public TimelineAdapter(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public static class TimelineViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tvTweetText) TextView tvTweetText;
        @Bind(R.id.ivProfile) ImageView ivProfile;
        @Bind(R.id.tvUserName) TextView userName;
        @Bind(R.id.tvScreenName) TextView screenName;
        @Bind(R.id.tvTimeDuration) TextView timeDuration;
        @Bind(R.id.ivMedia) RoundedImageView ivMedia;
        @Bind(R.id.vMedia) VideoView vMedia;


        public TimelineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(TimelineViewHolder holder, int position) {
        // Get the data model based on position
        Tweet tweet = tweets.get(position);

        // Set item views based on the data model
        holder.tvTweetText.setText(tweet.getText());

        holder.userName.setText(tweet.getUser().getName());
        holder.screenName.setText("@" + tweet.getUser().getScreenName());
        holder.timeDuration.setText(tweet.getTimeSpan(tweet.getCreatedAt()));

        Media media = tweet.getEntities() != null && tweet.getEntities().getMedia() !=null && tweet.getEntities().getMedia().size() > 0 ? tweet.getEntities().getMedia().get(0) : null;
        String mediaUrl = media != null ? media.getMediaUrl() : null;
        if (media != null && media.getMediaUrl() != null && media.getType().equals("photo")) {
            if (media.getType().equals("photo")) {
                Picasso.with(holder.ivMedia.getContext()).load(mediaUrl).into(holder.ivMedia);
            }
        }
        Picasso.with(holder.ivProfile.getContext()).load(tweet.getUser().getProfileImageUrl()).into(holder.ivProfile);
    }

    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View tweetView = inflater.inflate(R.layout.tweet_item, parent, false);

        // Return a new holder instance
        TimelineViewHolder viewHolder = new TimelineViewHolder(tweetView);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return tweets != null ? tweets.size() : 0;
    }
}
