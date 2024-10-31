package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes2.dex */
public final class Comment extends GenericJson {

    @Key
    private String anchor;

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

    @Key
    private QuotedFileContent quotedFileContent;

    @Key
    private List<Reply> replies;

    @Key
    private Boolean resolved;

    public String getAnchor() {
        return this.anchor;
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

    public QuotedFileContent getQuotedFileContent() {
        return this.quotedFileContent;
    }

    public List<Reply> getReplies() {
        return this.replies;
    }

    public Boolean getResolved() {
        return this.resolved;
    }

    public Comment setAnchor(String str) {
        this.anchor = str;
        return this;
    }

    public Comment setAuthor(User user) {
        this.author = user;
        return this;
    }

    public Comment setContent(String str) {
        this.content = str;
        return this;
    }

    public Comment setCreatedTime(DateTime dateTime) {
        this.createdTime = dateTime;
        return this;
    }

    public Comment setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Comment setHtmlContent(String str) {
        this.htmlContent = str;
        return this;
    }

    public Comment setId(String str) {
        this.id = str;
        return this;
    }

    public Comment setKind(String str) {
        this.kind = str;
        return this;
    }

    public Comment setModifiedTime(DateTime dateTime) {
        this.modifiedTime = dateTime;
        return this;
    }

    public Comment setQuotedFileContent(QuotedFileContent quotedFileContent) {
        this.quotedFileContent = quotedFileContent;
        return this;
    }

    public Comment setReplies(List<Reply> list) {
        this.replies = list;
        return this;
    }

    public Comment setResolved(Boolean bool) {
        this.resolved = bool;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class QuotedFileContent extends GenericJson {

        @Key
        private String mimeType;

        @Key
        private String value;

        public String getMimeType() {
            return this.mimeType;
        }

        public String getValue() {
            return this.value;
        }

        public QuotedFileContent setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public QuotedFileContent setValue(String str) {
            this.value = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public QuotedFileContent set(String str, Object obj) {
            return (QuotedFileContent) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public QuotedFileContent clone() {
            return (QuotedFileContent) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Comment set(String str, Object obj) {
        return (Comment) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Comment clone() {
        return (Comment) super.clone();
    }
}
