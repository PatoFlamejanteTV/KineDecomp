package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public final class User extends GenericJson {

    @Key
    private String displayName;

    @Key
    private String emailAddress;

    @Key
    private String kind;

    /* renamed from: me */
    @Key
    private Boolean f15037me;

    @Key
    private String permissionId;

    @Key
    private String photoLink;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getKind() {
        return this.kind;
    }

    public Boolean getMe() {
        return this.f15037me;
    }

    public String getPermissionId() {
        return this.permissionId;
    }

    public String getPhotoLink() {
        return this.photoLink;
    }

    public User setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public User setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public User setKind(String str) {
        this.kind = str;
        return this;
    }

    public User setMe(Boolean bool) {
        this.f15037me = bool;
        return this;
    }

    public User setPermissionId(String str) {
        this.permissionId = str;
        return this;
    }

    public User setPhotoLink(String str) {
        this.photoLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public User set(String str, Object obj) {
        return (User) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public User clone() {
        return (User) super.clone();
    }
}
