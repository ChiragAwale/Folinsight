package com.chiragawale.folinsight.entity;

/**
 * Entity Class for Follower Details
 */
public class Follower {
    int followerID;
    String userName,fullName,profilePictureLink;
    String date_trackedFrom,profileLink;
    int likesPosted,commentsPosted;
    boolean follow;

    public Follower(int followerID, String userName, String fullName, String profilePictureLink, String date_trackedFrom, boolean follow) {
        this.followerID = followerID;
        this.userName = userName;
        this.fullName = fullName;
        this.profilePictureLink = profilePictureLink;
        this.date_trackedFrom = date_trackedFrom;
        this.follow = follow;
        this.profileLink = "https://www.instagram.com/"+userName;
    }


    public Follower() {
    }

    public int getFollowerID() {
        return followerID;
    }

    public void setFollowerID(int followerID) {
        this.followerID = followerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePictureLink() {
        return profilePictureLink;
    }

    public void setProfilePictureLink(String profilePictureLink) {
        this.profilePictureLink = profilePictureLink;
    }

    public String getDate_trackedFrom() {
        return date_trackedFrom;
    }

    public void setDate_trackedFrom(String date_trackedFrom) {
        this.date_trackedFrom = date_trackedFrom;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }

    public String getProfileLink (){
        return profileLink;
    }

    public int getLikesPosted() {
        return likesPosted;
    }

    public void setLikesPosted(int likesPosted) {
        this.likesPosted = likesPosted;
    }

    public int getCommentsPosted() {
        return commentsPosted;
    }

    public void setCommentsPosted(int commentsPosted) {
        this.commentsPosted = commentsPosted;
    }
}
