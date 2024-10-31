package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes2.dex */
public final class RevisionList extends GenericJson {

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    @Key
    private List<Revision> revisions;

    static {
        Data.b((Class<?>) Revision.class);
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public List<Revision> getRevisions() {
        return this.revisions;
    }

    public RevisionList setKind(String str) {
        this.kind = str;
        return this;
    }

    public RevisionList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public RevisionList setRevisions(List<Revision> list) {
        this.revisions = list;
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
