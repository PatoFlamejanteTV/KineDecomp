package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Revision extends GenericJson {

    @Key
    private Map<String, String> exportLinks;

    @Key
    private String id;

    @Key
    private Boolean keepForever;

    @Key
    private String kind;

    @Key
    private User lastModifyingUser;

    @Key
    private String md5Checksum;

    @Key
    private String mimeType;

    @Key
    private DateTime modifiedTime;

    @Key
    private String originalFilename;

    @Key
    private Boolean publishAuto;

    @Key
    private Boolean published;

    @Key
    private Boolean publishedOutsideDomain;

    @JsonString
    @Key
    private Long size;

    public Map<String, String> getExportLinks() {
        return this.exportLinks;
    }

    public String getId() {
        return this.id;
    }

    public Boolean getKeepForever() {
        return this.keepForever;
    }

    public String getKind() {
        return this.kind;
    }

    public User getLastModifyingUser() {
        return this.lastModifyingUser;
    }

    public String getMd5Checksum() {
        return this.md5Checksum;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public DateTime getModifiedTime() {
        return this.modifiedTime;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Boolean getPublishAuto() {
        return this.publishAuto;
    }

    public Boolean getPublished() {
        return this.published;
    }

    public Boolean getPublishedOutsideDomain() {
        return this.publishedOutsideDomain;
    }

    public Long getSize() {
        return this.size;
    }

    public Revision setExportLinks(Map<String, String> map) {
        this.exportLinks = map;
        return this;
    }

    public Revision setId(String str) {
        this.id = str;
        return this;
    }

    public Revision setKeepForever(Boolean bool) {
        this.keepForever = bool;
        return this;
    }

    public Revision setKind(String str) {
        this.kind = str;
        return this;
    }

    public Revision setLastModifyingUser(User user) {
        this.lastModifyingUser = user;
        return this;
    }

    public Revision setMd5Checksum(String str) {
        this.md5Checksum = str;
        return this;
    }

    public Revision setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public Revision setModifiedTime(DateTime dateTime) {
        this.modifiedTime = dateTime;
        return this;
    }

    public Revision setOriginalFilename(String str) {
        this.originalFilename = str;
        return this;
    }

    public Revision setPublishAuto(Boolean bool) {
        this.publishAuto = bool;
        return this;
    }

    public Revision setPublished(Boolean bool) {
        this.published = bool;
        return this;
    }

    public Revision setPublishedOutsideDomain(Boolean bool) {
        this.publishedOutsideDomain = bool;
        return this;
    }

    public Revision setSize(Long l) {
        this.size = l;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Revision set(String str, Object obj) {
        return (Revision) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Revision clone() {
        return (Revision) super.clone();
    }
}
