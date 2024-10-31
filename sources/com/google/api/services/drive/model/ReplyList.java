package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes2.dex */
public final class ReplyList extends GenericJson {

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    @Key
    private List<Reply> replies;

    static {
        Data.b((Class<?>) Reply.class);
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public List<Reply> getReplies() {
        return this.replies;
    }

    public ReplyList setKind(String str) {
        this.kind = str;
        return this;
    }

    public ReplyList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public ReplyList setReplies(List<Reply> list) {
        this.replies = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ReplyList set(String str, Object obj) {
        return (ReplyList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ReplyList clone() {
        return (ReplyList) super.clone();
    }
}
