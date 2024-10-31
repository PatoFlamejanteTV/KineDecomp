package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class Acl extends GenericJson {

    @Key
    private String description;

    @Key
    private List<PlusAclentryResource> items;

    @Key
    private String kind;

    public String getDescription() {
        return this.description;
    }

    public Acl setDescription(String str) {
        this.description = str;
        return this;
    }

    public List<PlusAclentryResource> getItems() {
        return this.items;
    }

    public Acl setItems(List<PlusAclentryResource> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Acl setKind(String str) {
        this.kind = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Acl set(String str, Object obj) {
        return (Acl) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Acl clone() {
        return (Acl) super.clone();
    }
}
