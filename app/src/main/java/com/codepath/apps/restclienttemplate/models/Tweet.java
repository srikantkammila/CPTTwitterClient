
package com.codepath.apps.restclienttemplate.models;

import android.text.format.DateUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatterBuilder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
@Table(name = "tweets")
public class Tweet extends Model{

    public Tweet() {
    }


    public Tweet(String idStr, String createdAt, String text, User user, Double remoteId) {
        this.idStr = idStr;
        this.createdAt = createdAt;
        this.text = text;
        this.user = user;
        this.remoteId = remoteId;
    }

    @Column(name = "remote_id")
    @SerializedName("id")
    private Double remoteId;

    private Object coordinates;
    private Boolean truncated;

    @Column(name = "created_at")
    @SerializedName("created_at")
    private String createdAt;
    private Boolean favorited;

    @Column(name = "id_str", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("id_str")
    private String idStr;
    private Object inReplyToUserIdStr;

    @SerializedName("entities")
    @Column(name = "entities", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    private Entities entities;

    @Column(name = "text")
    private String text;
    private Object contributors;


    private Integer retweetCount;
    private Object inReplyToStatusIdStr;
    private Object geo;
    private Boolean retweeted;
    private Object inReplyToUserId;
    private Object place;

    @Column(name = "user", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    private User user;
    private Object inReplyToScreenName;
    private Object inReplyToStatusId;
    private Boolean possiblySensitive;
    private String source;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The coordinates
     */
    public Object getCoordinates() {
        return coordinates;
    }

    /**
     * 
     * @param coordinates
     *     The coordinates
     */
    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * 
     * @return
     *     The truncated
     */
    public Boolean getTruncated() {
        return truncated;
    }

    /**
     * 
     * @param truncated
     *     The truncated
     */
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getUnixTime(String createdAt) {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(createdAt );
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getTimeSpan(String createdAt) {
        long timeMilli = getUnixTime(createdAt);
        long nowLngTime = System.currentTimeMillis();
        DateTime dateTime = new DateTime(timeMilli);
        DateTime now = new DateTime();
        long difference = Math.abs(timeMilli - nowLngTime);
        Period period = new Period(dateTime, now);
        PeriodFormatterBuilder formatterBuilder = new PeriodFormatterBuilder();
        if (difference > DateUtils.YEAR_IN_MILLIS) {
            formatterBuilder.appendYears().appendSuffix("y");
        } else if (difference > DateUtils.DAY_IN_MILLIS * 30) {
            formatterBuilder.appendMonths().appendSuffix("mo");
        } else if (difference > DateUtils.WEEK_IN_MILLIS) {
            formatterBuilder.appendWeeks().appendSuffix("w");
        } else if (difference > DateUtils.DAY_IN_MILLIS) {
            formatterBuilder.appendDays().appendSuffix("d");
        } else if (difference > DateUtils.HOUR_IN_MILLIS) {
            formatterBuilder.appendHours().appendSuffix("h");
        } else if (difference > DateUtils.MINUTE_IN_MILLIS) {
            formatterBuilder.appendMinutes().appendSuffix("mi");
        } else if (difference > DateUtils.SECOND_IN_MILLIS) {
            formatterBuilder.appendSeconds().appendSuffix("s");
        }
        String ends = formatterBuilder.printZeroNever().toFormatter().print(period);
//        String plural = ends.startsWith("1 ")?"":"s";
        return ends;
    }

    public Double getRemote_id() {
        return remoteId;
    }

    public void setRemote_id(Double remote_id) {
        this.remoteId = remote_id;
    }

    /**
     * 
     * @return
     *     The favorited
     */
    public Boolean getFavorited() {
        return favorited;
    }

    /**
     * 
     * @param favorited
     *     The favorited
     */
    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    /**
     * 
     * @return
     *     The idStr
     */
    public String getIdStr() {
        return idStr;
    }

    /**
     * 
     * @param idStr
     *     The id_str
     */
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    /**
     * 
     * @return
     *     The inReplyToUserIdStr
     */
    public Object getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    /**
     * 
     * @param inReplyToUserIdStr
     *     The in_reply_to_user_id_str
     */
    public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    /**
     * 
     * @return
     *     The entities
     */
    public Entities getEntities() {
        return entities;
    }

    /**
     * 
     * @param entities
     *     The entities
     */
    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The contributors
     */
    public Object getContributors() {
        return contributors;
    }

    /**
     * 
     * @param contributors
     *     The contributors
     */
    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }


    /**
     * 
     * @return
     *     The retweetCount
     */
    public Integer getRetweetCount() {
        return retweetCount;
    }

    /**
     * 
     * @param retweetCount
     *     The retweet_count
     */
    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    /**
     * 
     * @return
     *     The inReplyToStatusIdStr
     */
    public Object getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    /**
     * 
     * @param inReplyToStatusIdStr
     *     The in_reply_to_status_id_str
     */
    public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    /**
     * 
     * @return
     *     The geo
     */
    public Object getGeo() {
        return geo;
    }

    /**
     * 
     * @param geo
     *     The geo
     */
    public void setGeo(Object geo) {
        this.geo = geo;
    }

    /**
     * 
     * @return
     *     The retweeted
     */
    public Boolean getRetweeted() {
        return retweeted;
    }

    /**
     * 
     * @param retweeted
     *     The retweeted
     */
    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    /**
     * 
     * @return
     *     The inReplyToUserId
     */
    public Object getInReplyToUserId() {
        return inReplyToUserId;
    }

    /**
     * 
     * @param inReplyToUserId
     *     The in_reply_to_user_id
     */
    public void setInReplyToUserId(Object inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    /**
     * 
     * @return
     *     The place
     */
    public Object getPlace() {
        return place;
    }

    /**
     * 
     * @param place
     *     The place
     */
    public void setPlace(Object place) {
        this.place = place;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The inReplyToScreenName
     */
    public Object getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    /**
     * 
     * @param inReplyToScreenName
     *     The in_reply_to_screen_name
     */
    public void setInReplyToScreenName(Object inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    /**
     * 
     * @return
     *     The inReplyToStatusId
     */
    public Object getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    /**
     * 
     * @param inReplyToStatusId
     *     The in_reply_to_status_id
     */
    public void setInReplyToStatusId(Object inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    /**
     * 
     * @return
     *     The possiblySensitive
     */
    public Boolean getPossiblySensitive() {
        return possiblySensitive;
    }

    /**
     * 
     * @param possiblySensitive
     *     The possibly_sensitive
     */
    public void setPossiblySensitive(Boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public static List<Tweet> getNextSet(String sinceId) {
        From sl = new Select()
                .distinct()
                .from(Tweet.class)
                .orderBy("id_str DESC")
                .limit(8);
        if (sinceId != null) {
            sl = sl.where("remote_id < " + sinceId);
        }

        return sl.execute();
    }


}
