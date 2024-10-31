package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class CommentFeed extends GenericJson {

    @Key
    private String etag;

    @Key
    private String id;

    @Key
    private List<Comment> items;

    @Key
    private String kind;

    @Key
    private String nextLink;

    @Key
    private String nextPageToken;

    @Key
    private String title;

    @Key
    private DateTime updated;

    static {
        Data.a((Class<?>) Comment.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public CommentFeed setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public CommentFeed setId(String str) {
        this.id = str;
        return this;
    }

    public List<Comment> getItems() {
        return this.items;
    }

    public CommentFeed setItems(List<Comment> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public CommentFeed setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getNextLink() {
        return this.nextLink;
    }

    public CommentFeed setNextLink(String str) {
        this.nextLink = str;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public CommentFeed setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public CommentFeed setTitle(String str) {
        this.title = str;
        return this;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public CommentFeed setUpdated(DateTime dateTime) {
        this.updated = dateTime;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CommentFeed set(String str, Object obj) {
        return (CommentFeed) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CommentFeed clone() {
        return (CommentFeed) super.clone();
    }
}
