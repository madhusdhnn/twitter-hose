package com.example.twitterhose.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import twitter4j.Status;

import java.util.Date;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TweetData {

    @JsonSerialize(using = DateSerializer.class)
    private Date createdAt;
    private Long id;
    private String idStr;
    private String text;
    private String source;
    private Boolean truncated;
    private User user;
    private RetweetedStatus retweetedStatus;
    private Boolean isQuoteStatus;
    private Long quoteCount;
    private Long replyCount;
    private Long retweetCount;
    private Long favoriteCount;
    private Boolean favorited;
    private Boolean retweeted;
    private String filterLevel;
    private String lang;
    private String timestampMs;

    public TweetData(Status twitter4jStatus) {
        this.createdAt = twitter4jStatus.getCreatedAt();
        this.id = twitter4jStatus.getId();
        this.idStr = String.valueOf(twitter4jStatus.getId());
        this.text = twitter4jStatus.getText();
        this.source = twitter4jStatus.getSource();
        this.truncated = twitter4jStatus.isTruncated();
        twitter4j.User user = twitter4jStatus.getUser();
        this.user = user != null ? new User(user) : null;
        Status retweetedStatus = twitter4jStatus.getRetweetedStatus();
        this.retweetedStatus = retweetedStatus != null ? new RetweetedStatus(retweetedStatus) : null;
        this.isQuoteStatus = twitter4jStatus.getQuotedStatus() != null;
        this.quoteCount = 0L;
        this.replyCount = 0L;
        this.retweetCount = (long) twitter4jStatus.getRetweetCount();
        this.favoriteCount = (long) twitter4jStatus.getFavoriteCount();
        this.favorited = twitter4jStatus.isFavorited();
        this.retweeted = twitter4jStatus.isRetweeted();
        this.filterLevel = String.valueOf(twitter4jStatus.getAccessLevel());
        this.lang = twitter4jStatus.getLang();
        this.timestampMs = "";
    }

}
