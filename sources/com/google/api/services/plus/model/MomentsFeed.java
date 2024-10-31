package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class MomentsFeed extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Moment> items;

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

    static {
        Data.a((Class<?>) Moment.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public MomentsFeed setEtag(String str) {
        this.etag = str;
        return this;
    }

    public List<Moment> getItems() {
        return this.items;
    }

    public MomentsFeed setItems(List<Moment> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public MomentsFeed setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getNextLink() {
        return this.nextLink;
    }

    public MomentsFeed setNextLink(String str) {
        this.nextLink = str;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public MomentsFeed setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public MomentsFeed setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public MomentsFeed setTitle(String str) {
        this.title = str;
        return this;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public MomentsFeed setUpdated(DateTime dateTime) {
        this.updated = dateTime;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public MomentsFeed set(String str, Object obj) {
        return (MomentsFeed) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public MomentsFeed clone() {
        return (MomentsFeed) super.clone();
    }
}
