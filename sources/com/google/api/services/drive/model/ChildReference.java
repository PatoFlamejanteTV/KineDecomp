package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public final class ChildReference extends GenericJson {

    @Key
    private String childLink;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private String selfLink;

    public String getChildLink() {
        return this.childLink;
    }

    public ChildReference setChildLink(String str) {
        this.childLink = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public ChildReference setId(String str) {
        this.id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public ChildReference setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public ChildReference setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ChildReference set(String str, Object obj) {
        return (ChildReference) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ChildReference clone() {
        return (ChildReference) super.clone();
    }
}
