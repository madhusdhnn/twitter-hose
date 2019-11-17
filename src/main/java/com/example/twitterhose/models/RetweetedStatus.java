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
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class RetweetedStatus {

    @JsonSerialize(using = DateSerializer.class)
    private Date createdAt;
    private Long id;
    private String idStr;
    private String text;
    private String source;
    private Boolean truncated;
    private User user;
    private Boolean isQuoteStatus;
    private Long quoteCount;
    private Long replyCount;
    private Long retweetCount;
    private Long favoriteCount;
    private Boolean favorited;
    private Boolean retweeted;
    private String filterLevel;
    private String lang;

    public RetweetedStatus(Status retweetedStatus) {
        this.createdAt = retweetedStatus.getCreatedAt();
        this.id = retweetedStatus.getId();
        this.idStr = String.valueOf(retweetedStatus.getId());
        this.text = retweetedStatus.getText();
        this.source = retweetedStatus.getSource();
        this.truncated = retweetedStatus.isTruncated();
        this.user = new User(retweetedStatus.getUser());
        this.isQuoteStatus = retweetedStatus.getQuotedStatus() != null;
        this.quoteCount = 0L;
        this.replyCount = 0L;
        this.retweetCount = (long) retweetedStatus.getRetweetCount();
        this.favoriteCount = (long) retweetedStatus.getFavoriteCount();
        this.favorited = retweetedStatus.isFavorited();
        this.retweeted = retweetedStatus.isRetweeted();
        this.filterLevel = String.valueOf(retweetedStatus.getAccessLevel());
        this.lang = retweetedStatus.getLang();
    }

}
