package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public final class Reply extends GenericJson {

    @Key
    private String action;

    @Key
    private User author;

    @Key
    private String content;

    @Key
    private DateTime createdTime;

    @Key
    private Boolean deleted;

    @Key
    private String htmlContent;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private DateTime modifiedTime;

    public String getAction() {
        return this.action;
    }

    public User getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public DateTime getCreatedTime() {
        return this.createdTime;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getHtmlContent() {
        return this.htmlContent;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public DateTime getModifiedTime() {
        return this.modifiedTime;
    }

    public Reply setAction(String str) {
        this.action = str;
        return this;
    }

    public Reply setAuthor(User user) {
        this.author = user;
        return this;
    }

    public Reply setContent(String str) {
        this.content = str;
        return this;
    }

    public Reply setCreatedTime(DateTime dateTime) {
        this.createdTime = dateTime;
        return this;
    }

    public Reply setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Reply setHtmlContent(String str) {
        this.htmlContent = str;
        return this;
    }

    public Reply setId(String str) {
        this.id = str;
        return this;
    }

    public Reply setKind(String str) {
        this.kind = str;
        return this;
    }

    public Reply setModifiedTime(DateTime dateTime) {
        this.modifiedTime = dateTime;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Reply set(String str, Object obj) {
        return (Reply) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Reply clone() {
        return (Reply) super.clone();
    }
}
