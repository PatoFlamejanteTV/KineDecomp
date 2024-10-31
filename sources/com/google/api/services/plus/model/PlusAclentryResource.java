package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public final class PlusAclentryResource extends GenericJson {

    @Key
    private String displayName;

    @Key
    private String id;

    @Key
    private String type;

    public String getDisplayName() {
        return this.displayName;
    }

    public PlusAclentryResource setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public PlusAclentryResource setId(String str) {
        this.id = str;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public PlusAclentryResource setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PlusAclentryResource set(String str, Object obj) {
        return (PlusAclentryResource) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PlusAclentryResource clone() {
        return (PlusAclentryResource) super.clone();
    }
}
