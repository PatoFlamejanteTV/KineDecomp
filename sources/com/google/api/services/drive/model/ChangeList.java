package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class ChangeList extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Change> items;

    @Key
    private String kind;

    @JsonString
    @Key
    private Long largestChangeId;

    @Key
    private String nextLink;

    @Key
    private String nextPageToken;

    @Key
    private String selfLink;

    public String getEtag() {
        return this.etag;
    }

    public ChangeList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public List<Change> getItems() {
        return this.items;
    }

    public ChangeList setItems(List<Change> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public ChangeList setKind(String str) {
        this.kind = str;
        return this;
    }

    public Long getLargestChangeId() {
        return this.largestChangeId;
    }

    public ChangeList setLargestChangeId(Long l) {
        this.largestChangeId = l;
        return this;
    }

    public String getNextLink() {
        return this.nextLink;
    }

    public ChangeList setNextLink(String str) {
        this.nextLink = str;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ChangeList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public ChangeList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ChangeList set(String str, Object obj) {
        return (ChangeList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ChangeList clone() {
        return (ChangeList) super.clone();
    }
}
