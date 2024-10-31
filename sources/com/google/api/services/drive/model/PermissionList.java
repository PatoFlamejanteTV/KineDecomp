package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class PermissionList extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Permission> items;

    @Key
    private String kind;

    @Key
    private String selfLink;

    static {
        Data.a((Class<?>) Permission.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public PermissionList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public List<Permission> getItems() {
        return this.items;
    }

    public PermissionList setItems(List<Permission> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public PermissionList setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public PermissionList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PermissionList set(String str, Object obj) {
        return (PermissionList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PermissionList clone() {
        return (PermissionList) super.clone();
    }
}
