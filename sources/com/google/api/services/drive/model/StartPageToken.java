package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public final class StartPageToken extends GenericJson {

    @Key
    private String kind;

    @Key
    private String startPageToken;

    public String getKind() {
        return this.kind;
    }

    public String getStartPageToken() {
        return this.startPageToken;
    }

    public StartPageToken setKind(String str) {
        this.kind = str;
        return this;
    }

    public StartPageToken setStartPageToken(String str) {
        this.startPageToken = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public StartPageToken set(String str, Object obj) {
        return (StartPageToken) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public StartPageToken clone() {
        return (StartPageToken) super.clone();
    }
}
