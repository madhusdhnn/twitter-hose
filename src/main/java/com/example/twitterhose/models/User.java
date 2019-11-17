package com.example.twitterhose.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    private Long id;
    private String idStr;
    private String name;
    private String screenName;
    private String location;
    private String description;
    private String translatorType;
    private Boolean protectedUser;
    private Boolean verified;
    private Long followersCount;
    private Long friendsCount;
    private Long listedCount;
    private Long favouritesCount;
    private Long statusesCount;
    @JsonSerialize(using = DateSerializer.class)
    private Date createdAt;
    private Boolean geoEnabled;
    private String lang;
    private Boolean contributorsEnabled;
    private Boolean isTranslator;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private Boolean profileBackgroundTile;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private Boolean profileUseBackgroundImage;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileBannerUrl;
    private Boolean defaultProfile;
    private Boolean defaultProfileImage;

    public User(twitter4j.User user) {
        this.id = user.getId();
        this.idStr = String.valueOf(user.getId());
        this.name = user.getName();
        this.screenName = user.getScreenName();
        this.location = user.getLocation();
        this.description = user.getDescription();
        this.translatorType = "";
        this.protectedUser = user.isProtected();
        this.verified = user.isVerified();
        this.followersCount = (long) user.getFollowersCount();
        this.friendsCount = (long) user.getFriendsCount();
        this.listedCount = (long) user.getListedCount();
        this.favouritesCount = (long) user.getFavouritesCount();
        this.statusesCount = (long) user.getStatusesCount();
        this.createdAt = user.getCreatedAt();
        this.geoEnabled = user.isGeoEnabled();
        this.lang = user.getLang();
        this.contributorsEnabled = user.isContributorsEnabled();
        this.isTranslator = user.isTranslator();
        this.profileBackgroundColor = user.getProfileBackgroundColor();
        this.profileBackgroundImageUrl = user.getProfileBackgroundImageURL();
        this.profileBackgroundImageUrlHttps = user.getProfileBackgroundImageUrlHttps();
        this.profileBackgroundTile = user.isProfileBackgroundTiled();
        this.profileLinkColor = user.getProfileLinkColor();
        this.profileSidebarBorderColor = user.getProfileSidebarBorderColor();
        this.profileSidebarFillColor = user.getProfileSidebarFillColor();
        this.profileTextColor = user.getProfileTextColor();
        this.profileUseBackgroundImage = user.isProfileUseBackgroundImage();
        this.profileImageUrl = user.getProfileImageURL();
        this.profileImageUrlHttps = user.getProfileImageURLHttps();
        this.profileBannerUrl = user.getProfileBannerURL();
        this.defaultProfile = user.isDefaultProfile();
        this.defaultProfileImage = user.isDefaultProfileImage();
    }

}
