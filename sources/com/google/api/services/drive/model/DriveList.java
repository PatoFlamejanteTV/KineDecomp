package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes2.dex */
public final class DriveList extends GenericJson {

    @Key
    private List<Drive> drives;

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    static {
        Data.b((Class<?>) Drive.class);
    }

    public List<Drive> getDrives() {
        return this.drives;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public DriveList setDrives(List<Drive> list) {
        this.drives = list;
        return this;
    }

    public DriveList setKind(String str) {
        this.kind = str;
        return this;
    }

    public DriveList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public DriveList set(String str, Object obj) {
        return (DriveList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public DriveList clone() {
        return (DriveList) super.clone();
    }
}
