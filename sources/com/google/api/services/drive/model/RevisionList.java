package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class RevisionList extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Revision> items;

    @Key
    private String kind;

    @Key
    private String selfLink;

    static {
        Data.a((Class<?>) Revision.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public RevisionList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public List<Revision> getItems() {
        return this.items;
    }

    public RevisionList setItems(List<Revision> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public RevisionList setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public RevisionList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public RevisionList set(String str, Object obj) {
        return (RevisionList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public RevisionList clone() {
        return (RevisionList) super.clone();
    }
}
