package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public final class Moment extends GenericJson {

    @Key
    private String id;

    @Key
    private String kind;

    @Key(a = "object")
    private ItemScope object__;

    @Key
    private ItemScope result;

    @Key
    private DateTime startDate;

    @Key
    private ItemScope target;

    @Key
    private String type;

    public String getId() {
        return this.id;
    }

    public Moment setId(String str) {
        this.id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Moment setKind(String str) {
        this.kind = str;
        return this;
    }

    public ItemScope getObject() {
        return this.object__;
    }

    public Moment setObject(ItemScope itemScope) {
        this.object__ = itemScope;
        return this;
    }

    public ItemScope getResult() {
        return this.result;
    }

    public Moment setResult(ItemScope itemScope) {
        this.result = itemScope;
        return this;
    }

    public DateTime getStartDate() {
        return this.startDate;
    }

    public Moment setStartDate(DateTime dateTime) {
        this.startDate = dateTime;
        return this;
    }

    public ItemScope getTarget() {
        return this.target;
    }

    public Moment setTarget(ItemScope itemScope) {
        this.target = itemScope;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Moment setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Moment set(String str, Object obj) {
        return (Moment) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Moment clone() {
        return (Moment) super.clone();
    }
}
