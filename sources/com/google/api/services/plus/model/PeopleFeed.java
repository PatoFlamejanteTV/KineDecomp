package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class PeopleFeed extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Person> items;

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    @Key
    private String selfLink;

    @Key
    private String title;

    @Key
    private Integer totalItems;

    static {
        Data.a((Class<?>) Person.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public PeopleFeed setEtag(String str) {
        this.etag = str;
        return this;
    }

    public List<Person> getItems() {
        return this.items;
    }

    public PeopleFeed setItems(List<Person> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public PeopleFeed setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public PeopleFeed setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public PeopleFeed setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public PeopleFeed setTitle(String str) {
        this.title = str;
        return this;
    }

    public Integer getTotalItems() {
        return this.totalItems;
    }

    public PeopleFeed setTotalItems(Integer num) {
        this.totalItems = num;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PeopleFeed set(String str, Object obj) {
        return (PeopleFeed) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PeopleFeed clone() {
        return (PeopleFeed) super.clone();
    }
}
