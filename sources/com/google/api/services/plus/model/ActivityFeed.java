package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class ActivityFeed extends GenericJson {

    @Key
    private String etag;

    @Key
    private String id;

    @Key
    private List<Activity> items;

    @Key
    private String kind;

    @Key
    private String nextLink;

    @Key
    private String nextPageToken;

    @Key
    private String selfLink;

    @Key
    private String title;

    @Key
    private DateTime updated;

    public String getEtag() {
        return this.etag;
    }

    public ActivityFeed setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public ActivityFeed setId(String str) {
        this.id = str;
        return this;
    }

    public List<Activity> getItems() {
        return this.items;
    }

    public ActivityFeed setItems(List<Activity> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public ActivityFeed setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getNextLink() {
        return this.nextLink;
    }

    public ActivityFeed setNextLink(String str) {
        this.nextLink = str;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ActivityFeed setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public ActivityFeed setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public ActivityFeed setTitle(String str) {
        this.title = str;
        return this;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public ActivityFeed setUpdated(DateTime dateTime) {
        this.updated = dateTime;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ActivityFeed set(String str, Object obj) {
        return (ActivityFeed) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ActivityFeed clone() {
        return (ActivityFeed) super.clone();
    }
}
